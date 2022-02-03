import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
		int[] dp = new int[num];
		for(int i = 0; i < num; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i] && dp[j] >= dp[i]) dp[i] = dp[j] + 1; 
			}
			if(dp[i] == 0) dp[i] = 1;
		}
		int max = 0;
		for(int i = 0; i < num; i++) {
			if(dp[i] > max) max = dp[i];
		}
		System.out.println(max);
	}
}
