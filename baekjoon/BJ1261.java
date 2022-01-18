import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1261 {
	private static class Moving implements Comparable<Moving>{
		int r, c, aoj, cnt;
		public Moving(int r, int c, int aoj, int cnt) {
			this.r = r;
			this.c = c;
			this.aoj = aoj;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Moving o) {
			return this.aoj - o.aoj;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		for(int r = 0; r < row; r++) {
			map[r] = br.readLine().toCharArray();
		}
		int[] dr = new int[] {-1, 0, 1, 0};
		int[] dc = new int[] {0, -1, 0, 1};
		int[][][] vis = new int[row][col][]; 
		PriorityQueue<Moving> pq = new PriorityQueue<Moving>();
		pq.offer(new Moving(0, 0, 0, 0));
		
		while(!pq.isEmpty()) {
			Moving cur = pq.poll();
			if(cur.r == row - 1 && cur.c == col - 1) {
				System.out.println(cur.aoj);
				System.exit(0);
			}
			if(vis[cur.r][cur.c] == null) {
				vis[cur.r][cur.c] = new int[] {cur.aoj, cur.cnt};
			}
			else {
				if(vis[cur.r][cur.c][0] > cur.aoj) {
					vis[cur.r][cur.c][0] = cur.aoj;
					vis[cur.r][cur.c][1] = cur.cnt;
				}
				else if(vis[cur.r][cur.c][0] == cur.aoj) {
					if(vis[cur.r][cur.c][1] > cur.cnt) vis[cur.r][cur.c][1] = cur.cnt;
					else continue;
				}
				else {
					continue;
				}
			}
			int nr, nc;
			for(int d = 0; d < 4; d++) {
				nr = cur.r + dr[d];
				nc = cur.c + dc[d];
				if(nr >= 0 && nr < row && nc >= 0 && nc < col) pq.offer(new Moving(nr, nc, cur.aoj + map[nr][nc] - 48, cur.cnt + 1));
			}
		}
	}
}
