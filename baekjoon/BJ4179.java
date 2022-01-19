import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4179 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		for(int r = 0; r < row; r++) {
			map[r] = br.readLine().toCharArray();
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int[][] vis = new int[row][col];
		int[] jh = new int[3];
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(map[r][c] == 'J') {
					jh[0] = r;
					jh[1] = c;
				} else if(map[r][c] == 'F') {
					pq.offer(new int[] {r, c, 0});
				} 
				if(map[r][c] != '#') {
					vis[r][c] = Integer.MAX_VALUE;
				}
			}
		}
		int[] dr = new int[] {-1, 0, 1, 0};
		int[] dc = new int[] {0, -1, 0, 1};
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(vis[cur[0]][cur[1]] <= cur[2]) continue;
			vis[cur[0]][cur[1]] = cur[2];
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
				pq.offer(new int[] {nr, nc, cur[2] + 1});
			}
		}
		pq.offer(jh);
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(vis[cur[0]][cur[1]] <= cur[2]) continue;
			vis[cur[0]][cur[1]] = cur[2];
			if(cur[0] == 0 || cur[0] == row-1 || cur[1] == 0 || cur[1] == col-1) {
				System.out.println(cur[2] + 1);
				System.exit(0);
			}
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
				pq.offer(new int[] {nr, nc, cur[2] + 1});
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}
