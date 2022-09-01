import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1103 {
	private static int N, M;
	private static char[][] map;
	private static int[][] dp;
	private static boolean[][] vis;
	private static int[] dr = new int[] {1, 0, -1, 0};
	private static int[] dc = new int[] {0, -1, 0, 1};
	private static int find(int r, int c) {
		if(dp[r][c] != 0 || map[r][c] == 'H') return dp[r][c];
		if(vis[r][c]) return Integer.MAX_VALUE;
		vis[r][c] = true;
		int num = map[r][c] - '0';
		int nr, nc, maxValue = 0;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d] * num;
			nc = c + dc[d] * num;
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			maxValue = Math.max(maxValue, find(nr, nc));
			if(maxValue == Integer.MAX_VALUE) return Integer.MAX_VALUE;
		}
		vis[r][c] = false;
		dp[r][c] = maxValue + 1;
		return dp[r][c];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		for(int n = 0; n < N; n++) {
			map[n] = br.readLine().toCharArray();
		}
		dp = new int[N][M];
		vis = new boolean[N][M];
		 
		System.out.println(find(0, 0) != Integer.MAX_VALUE ? dp[0][0] : -1);
	}
}
