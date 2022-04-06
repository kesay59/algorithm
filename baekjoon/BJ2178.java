import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		int[][] vis = new int[row][col];
		for(int r = 0; r < row; r++) {
			map[r] = br.readLine().toCharArray();
			Arrays.fill(vis[r], Integer.MAX_VALUE);
		}
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0, 0, 1});
		int[] dr = new int[] {-1, 0, 1, 0};
		int[] dc = new int[] {0, 1, 0, -1};
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0] == row-1 && cur[1] == col-1) {
				System.out.println(cur[2]);
				return;
			}
			if(vis[cur[0]][cur[1]] <= cur[2]) continue;
			vis[cur[0]][cur[1]] = cur[2];
			int nr, nc;
			for(int d = 0; d < 4; d++) {
				nr = cur[0] + dr[d];
				nc = cur[1] + dc[d];
				if(nr < 0 || nr >= row || nc < 0 || nc >= col || map[nr][nc] == '0') continue;
				que.offer(new int[] {nr, nc, cur[2] + 1});
			}
		}
	}
}
