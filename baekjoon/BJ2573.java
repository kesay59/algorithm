import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2573 {
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, -1, 0, 1};
	private static boolean checkConnection(int[][] map, int num, int r, int c) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r, c});
		boolean[][] vis = new boolean[map.length][map[0].length];
		int cnt = 0;
		int[] cur;
		int nr, nc;
		while(!que.isEmpty()) {
			cur = que.poll();
			if(vis[cur[0]][cur[1]] || map[cur[0]][cur[1]] == 0) continue;
			vis[cur[0]][cur[1]] = true;
			cnt++;
			for(int d = 0; d < 4; d++) {
				nr = cur[0] + dr[d];
				nc = cur[1] + dc[d];
				if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) continue;
				que.offer(new int[] {nr, nc});
			}
		}
		if(cnt != num) return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][][] map = new int[2][row][col];
		Queue<int[]> que = new LinkedList<int[]>();
		for(int r = 0; r < row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < col; c++) {
				map[0][r][c] = Integer.parseInt(st.nextToken());
				map[1][r][c] = map[0][r][c];
				if(map[0][r][c] > 0) {
					que.offer(new int[] {r, c});
				}
			}
		}
		que.offer(new int[] {-1});
		int year = 0;
		int flag = 0;
		while(que.peek()[0] != -1) {
			if(!checkConnection(map[flag], que.size()-1, que.peek()[0], que.peek()[1])) {
				System.out.println(year);
				System.exit(0);
			}
			int[] cur;
			int cnt, nr, nc;
			while(que.peek()[0] != -1) {
				cur = que.poll();
				cnt = 0;
				for(int d = 0; d < 4; d++) {
					nr = cur[0] + dr[d];
					nc = cur[1] + dc[d];
					if(nr < 0 || nr >= map[flag].length || nc < 0 || nc >= map[flag][0].length) continue;
					if(map[flag][nr][nc] == 0) cnt++;
				}
				map[flag^1][cur[0]][cur[1]] = map[flag][cur[0]][cur[1]] - cnt;
				if(map[flag^1][cur[0]][cur[1]] <= 0) map[flag^1][cur[0]][cur[1]] = 0;
				else que.offer(cur);
			}
			que.offer(que.poll());
			for(int r = 0; r < row; r++) {
				Arrays.fill(map[flag][r], 0);
			}
			year++;
			flag ^= 1;

		}
		System.out.println(0);
	}
}
