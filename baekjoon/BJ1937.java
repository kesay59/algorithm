import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1937 {
	private static int N;
	private static int[][] map;
	private static int[][] dp;
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	private static int dfs(int r, int c, int cnt) {
		if(dp[r][c] != 0) return dp[r][c];
		int max = 1;
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] <= map[r][c]) continue;
			max = Math.max(max, dfs(nr, nc, cnt + 1) + 1);
		}
		dp[r][c] = max;
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {				
				map[i][j] = Integer.parseInt(st.nextToken());
				pq.offer(new int[] {i, j, map[i][j]});
			}
		}
		dp = new int[N][N];
		int[] cur;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			dfs(cur[0], cur[1], 1);
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				answer = Math.max(answer, dp[i][j]);
			}
		}
		System.out.println(answer);
	}
}
