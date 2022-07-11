import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];
		for(int n = 0; n <= N; n++) {
			Arrays.fill(map[n], 1000 * N + 1);
			map[n][n] = 0;
		}
		int a, b, cost;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			map[a][b] = cost;
			map[b][a] = cost;
		}
		int[][] dp = new int[N+1][N+1];
		int[][] route = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = map[i][j];
				route[i][j] = j;
			}
		}
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(dp[i][j] > dp[i][k] + dp[k][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
						route[i][j] = route[i][k];
					}
				}
			}
		}
		StringBuilder stb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				stb.append(i == j ? "-" : route[i][j]).append(' ');
			}
			stb.append('\n');
		}
		System.out.println(stb.toString());
	}
}
