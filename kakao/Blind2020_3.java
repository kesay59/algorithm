import java.util.ArrayList;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
    	int lockLeng = lock.length;
    	int keyLeng = key.length;
    	int border = lockLeng - 1;
    	
    	ArrayList<int[]> blankList = new ArrayList<>();
    	ArrayList<int[]> fillList = new ArrayList<>();
    	for(int r = 0; r < lockLeng; r++) {
    		for(int c = 0; c < lockLeng; c++) {
    			if(lock[r][c] == 0) blankList.add(new int[] {r, c});
    			else fillList.add(new int[] {r, c});
    		}
    	}
    	
    	int[][][] partList = new int[4][keyLeng + border + border][keyLeng + border + border];
    	for(int r = 0; r < keyLeng; r++) {
    		for(int c = 0; c < keyLeng; c++) {
    			partList[0][r + border][c + border] = key[r][c];
    			partList[1][c + border][keyLeng - 1 - r + border] = key[r][c];
    			partList[2][keyLeng - 1 - r + border][keyLeng - 1 - c + border] = key[r][c];
    			partList[3][keyLeng - 1 - c + border][r + border] = key[r][c];
    		}
    	}
    	
    	
        boolean answer = false;
    	out : for(int p = 0; p < 4; p++) {
    		for(int i = 0; i < keyLeng + lockLeng - 1; i++) {
    			next : for(int j = 0; j < keyLeng + lockLeng - 1; j++) {
    				for(int[] blank : blankList) {
    					if(partList[p][blank[0] + i][blank[1] + j] == 0) continue next;
    				}
    				for(int[] fill : fillList) {
    					if(partList[p][fill[0] + i][fill[1] + j] == 1) continue next;
    				}
    				answer = true;
    				break out;
    			}
    		}
    	}
        return answer;
    }
}