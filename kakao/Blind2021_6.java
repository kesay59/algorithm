import java.util.HashMap;

class Solution {
	
	private int open = 0;
	private int openR = 0, openC = 0;
	private int minCnt = 40; // 카드 이동(6+6+4+4+4+4) 뒤집기(2*6)
	private boolean[] cardList = new boolean[7];
	private HashMap<String, Integer>[][] visited = new HashMap[4][4]; //r, c
	
	// key(1~6 + _ + open)
	private String makeKey() {
		StringBuilder stb = new StringBuilder();
		for(int i = 1; i < 7; i++) {
			if(cardList[i]) stb.append(i);
		}
		stb.append("_");
		stb.append(open);
		stb.append(openR);
		stb.append(openC);
		return stb.toString();
	}
	
	// ←, ↑, ↓, → 0 1 2 3
	private int[] move(int[][] board, int r, int c, int dir, boolean isCtrl) {
		int oriR = r;
		int oriC = c;
		if(dir == 0) {
			if(isCtrl) {
				while(c > 0) {
					c--;
					if(board[r][c] != 0) break;
				}
			}
			else {
				if(c > 0) c--;
			}
		}
		else if(dir == 1) {
			if(isCtrl) {
				while(r > 0) {
					r--;
					if(board[r][c] != 0) break;
				}
			}
			else {
				if(r > 0) r--;
			}

		} 
		else if(dir == 2) {
			if(isCtrl) {
				while(r < 3) {
					r++;
					if(board[r][c] != 0) break;
				}
			}
			else {
				if(r < 3) r++;
			}

		} 
		else if(dir == 3) {
			if(isCtrl) {
				while(c < 3) {
					c++;
					if(board[r][c] != 0) break;
				}
			}
			else {
				if(c < 3) c++;
			}
		}
		if(oriR == r && oriC == c) return null;
		return new int[] {r, c};
	}
	
	private void dfs(int[][] board, int r, int c, int cnt) {
		String key = makeKey();
		if(minCnt <= cnt) return;
		if(visited[r][c].containsKey(key) && visited[r][c].get(key) <= cnt) return;
		
		int i = 1;
		for(; i < 7; i++) {
			if(cardList[i]) break;
		}
		if(i == 7) {
 			minCnt = cnt;
			return;
		}
		
		visited[r][c].put(key, cnt);

		int oriOpen = open;
		int oriOpenR = openR;
		int oriOpenC = openC;
		int oriNum = board[r][c];
		if(open != 0 && open == board[r][c]) {
			cardList[open] = false;
			board[r][c] = 0;
			board[openR][openC] = 0;
			open = 0;
			dfs(board, r, c, cnt + 1);
			open = oriOpen;
			board[r][c] = oriNum;
			board[openR][openC] = 10;
			cardList[open] = true;
		}
		if(open == 0 && board[r][c] != 0) {
			open = board[r][c];
			openR = r;
			openC = c;
			board[r][c] = 10;
			dfs(board, r, c, cnt + 1);
			open = oriOpen;
			openR = oriOpenR;
			openC = oriOpenC;
			board[r][c] = oriNum;
		}
		
		for(int d = 0; d < 4; d++) {
			int[] res = move(board, r, c, d, true);
			if(res != null) dfs(board, res[0], res[1], cnt+1);
			res = move(board, r, c, d, false);
			if(res != null) dfs(board, res[0], res[1], cnt+1);
		}
	}
	
    public int solution(int[][] board, int r, int c) {
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			cardList[board[i][j]] = true;
    			visited[i][j] = new HashMap<>();
    		}
    	}
    	
    	dfs(board, r, c, 0);
    	
        int answer = minCnt;
        return answer;
    }
}