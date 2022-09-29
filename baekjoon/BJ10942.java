import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		boolean[][] dp = new boolean[N][N];
		int sta, end;
		for(int i = 0; i < N - 1; i++) {
			sta = i;
			end = i;
			while(sta >= 0 && end < N) {
				if(arr[sta] != arr[end]) break;
				dp[sta][end] = true;
				sta--;
				end++;
			}
			sta = i;
			end = i+1;
			while(sta >= 0 && end < N) {
				if(arr[sta] != arr[end]) break;
				dp[sta][end] = true;
				sta--;
				end++;
			}
		}
		dp[N-1][N-1] = true;
		int T = Integer.parseInt(br.readLine());
		StringBuilder stb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			stb.append(dp[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] ? 1 : 0).append('\n');
		}
		System.out.print(stb.toString());
	}
}