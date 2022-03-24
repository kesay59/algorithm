import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1038 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num < 10) {
			System.out.println(num);
			System.exit(0);
		}
		
		int[][] dp = new int[10][10];
		Arrays.fill(dp[0], 1);
		out : for(int i = 1; i < 10; i++) {
			for(int j = 0; j < i; j++) {
				dp[i][j] = 0;
			}
			dp[i][i] = dp[i-1][i-1];
			for(int j = i+1; j < 10; j++) {
				dp[i][j] = 0;
				for(int k = 0; k < j; k++) {
					dp[i][j] += dp[i-1][k];
				}
			}
		}
		int loc = 0, val = 0;
		int cnt = -1;
		out : for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 ;j++) {
				cnt += dp[i][j];
				if(cnt >= num) {
					loc = i;
					val = j;
					break out;
				}
			}
		}
		
		if(loc == 0 && val == 0) {
			System.out.println(-1);
			System.exit(0);
		}
		StringBuilder answerStb = new StringBuilder();
		for(; loc >= 0; loc--) {
			answerStb.append(val);
			if(val > 0) val--;
		}
		long answer = Long.parseLong(answerStb.toString());
		char[] tmp;
		out : while(cnt > num) {
			answer--;
			tmp = Long.toString(answer).toCharArray();
			for(int t = 1; t < tmp.length; t++) {
				if(tmp[t] >= tmp[t-1]) continue out;
			}
			cnt--;
		}
		System.out.println(answer);
	}
}
