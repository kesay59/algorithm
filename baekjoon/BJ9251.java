import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		int[][] dp = new int[arr1.length + 1][arr2.length + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length; j++) {
				dp[i][j] = arr1[i-1] == arr2[j-1] ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[arr1.length][arr2.length]);
	}
}
