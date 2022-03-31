import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < testCase; tc++) {
			int num = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][3];
			int flag = 0;
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int n = 0; n < num; n++) {
				dp[flag][0] = Math.max(dp[flag^1][1], dp[flag^1][2]) + Integer.parseInt(st1.nextToken());
				dp[flag][1] = Math.max(dp[flag^1][0], dp[flag^1][2]) + Integer.parseInt(st2.nextToken());
				dp[flag][2] = Math.max(Math.max(dp[flag^1][0], dp[flag^1][1]), dp[flag^1][2]);
				flag ^= 1;
			}
			stb.append(Math.max(Math.max(dp[flag^1][0], dp[flag^1][1]), dp[flag^1][2])).append('\n');
		}
		System.out.println(stb.toString());
	}
}
