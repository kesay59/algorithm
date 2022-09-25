import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class BJ2011 {
	public static void main(String[] args) throws IOException {
		String line = "00" + new BufferedReader(new InputStreamReader(System.in)).readLine();
		int[] dp = new int[line.length()];
		dp[0] = dp[1] = 1;
		for(int idx = 2; idx < line.length(); idx++) {
			if(line.charAt(idx) != '0')	dp[idx] += dp[idx-1];
			if(line.charAt(idx-1) == '1' || (line.charAt(idx-1) == '2' && line.charAt(idx) <= '6')) dp[idx] += dp[idx-2];
			dp[idx] %= 1000000;
		}
		System.out.println(dp[line.length() - 1]);
	}
}
