import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	private int[] dr = new int[] {-1, 0, 1, 0};
	private int[] dc = new int[] {0, 1, 0, -1};
	
	private boolean search(char[][] place, int r, int c) {
    	boolean[][] visited = new boolean[5][5];
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r, c, 2});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(place[cur[0]][cur[1]] == 'P' && (cur[0] != r || cur[1] != c)) return true;
			if(cur[2] == 0 || visited[cur[0]][cur[1]]) continue;
			visited[cur[0]][cur[1]] = true;
			for(int idx = 0; idx < 4; idx++) {
				int nextR = cur[0] + dr[idx];
				int nextC = cur[1] + dc[idx];
				if(nextR < 0 || nextR >= 5 || nextC < 0 || nextC >= 5 || place[nextR][nextC] == 'X') continue;
				que.offer(new int[] {nextR, nextC, cur[2] - 1});
			}
		}
		return false;
	}
	
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        char[][] place = new char[5][];
        out : for(int idx = 0; idx < 5; idx++) {
        	for(int r = 0; r < 5; r++) {
        		place[r] = places[idx][r].toCharArray();
        	}
        	
        	for(int r = 0; r < 5; r++) {
        		for(int c = 0; c < 5; c++) {
        			if(place[r][c] == 'P') {
        				if(search(place, r, c)) {
        					answer[idx] = 0;
        					continue out;
        				}      				
        			}
        		}
        	}
        	answer[idx] = 1;
        }
        
        return answer;
    }
}