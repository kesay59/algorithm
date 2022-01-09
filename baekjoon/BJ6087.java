import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ6087 {
	private static class Light implements Comparable<Light>{
		int r, c, dir, cnt;
		public Light(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Light o) {
			return this.cnt - o.cnt;
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
		int[] sta = new int[2];
		out : for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 'C') {
					sta[0] = i;
					sta[1] = j;
					break out;
				}
			}
		}
		int[] dr = new int[] {-1, 0, 1, 0};
		int[] dc = new int[] {0, 1, 0, -1};
		PriorityQueue<Light> pq = new PriorityQueue<Light>();
		int[][][] vis = new int[row][col][4];
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {				
				Arrays.fill(vis[r][c], Integer.MAX_VALUE);
			}
		}
		Arrays.fill(vis[sta[0]][sta[1]], 0);
		for(int d = 0; d < 4 ; d++) {
			pq.offer(new Light(sta[0] + dr[d], sta[1] + dc[d], d, 0));
		}
		Light cur;
		int left, right;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(cur.r >= row || cur.r < 0 || cur.c >= col || cur.c < 0 || map[cur.r][cur.c] == '*' || vis[cur.r][cur.c][cur.dir] <= cur.cnt) continue;
			if(map[cur.r][cur.c] == 'C') {
				System.out.println(cur.cnt);
				System.exit(0);
			}
			vis[cur.r][cur.c][cur.dir] = cur.cnt;
			pq.offer(new Light(cur.r + dr[cur.dir], cur.c + dc[cur.dir], cur.dir, cur.cnt));
			left = (cur.dir + 3) % 4;
			right = (cur.dir + 1) % 4;
			pq.offer(new Light(cur.r + dr[left], cur.c + dc[left], left, cur.cnt+1));
			pq.offer(new Light(cur.r + dr[right], cur.c + dc[right], right, cur.cnt+1));
		}
	}
}
