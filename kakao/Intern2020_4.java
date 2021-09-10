import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	
	private class Loc implements Comparable<Loc>{
		int r, c, dir, cost;
		Loc(int r, int c, int dir, int cost){
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Loc o) {
			return this.cost - o.cost;
		}
	}
	
    public int solution(int[][] board) {
    	int leng = board.length;
    	int[][][] costmap = new int[leng][leng][4];
    	for(int ridx = 0; ridx < leng; ridx++) {
    		for(int cidx = 0; cidx < leng; cidx++) {
    			Arrays.fill(costmap[ridx][cidx], Integer.MAX_VALUE);
    		}
    	}
    	
    	int[] dr = new int[] {-1, 0, 1, 0};
    	int[] dc = new int[] {0, 1, 0, -1};
    	
    	PriorityQueue<Loc> locs = new PriorityQueue<>();
    	locs.add(new Loc(0, 0, 0, 0));
    	locs.add(new Loc(0, 0, 3, 0));
    	while(!locs.isEmpty()) {
    		Loc cur = locs.poll();
    		if(costmap[cur.r][cur.c][cur.dir] <= cur.cost) continue;
    		costmap[cur.r][cur.c][cur.dir] = cur.cost;
    		for(int idx = 0; idx < 4; idx++) {
    			if(idx == cur.dir) continue;
    			int nextR = cur.r + dr[idx];
    			int nextC = cur.c + dc[idx];
    			if(nextR < 0 || nextR >= leng || nextC < 0 || nextC >= leng || board[nextR][nextC] == 1) continue;
    			int nextCost = Math.abs(idx - cur.dir) == 2 ? cur.cost + 100 : cur.cost + 600;
    			locs.add(new Loc(nextR, nextC, (idx + 2) % 4, nextCost));
    		}
    	}
    	int answer = Integer.MAX_VALUE;
    	for(int idx = 0; idx < 4; idx++) {
    		answer = Math.min(answer, costmap[leng - 1][leng - 1][idx]);
    	}
        return answer;
    }
}
// dfs로 탐색하되 본인 칸에 들어온 최소 비용을 남긴다(가지치기)
// 좌표 비용 방향을 들고 이동
// 비용 기준 pq 사용