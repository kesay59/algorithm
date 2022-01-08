import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] appArr = new int[num][];
		StringTokenizer mst = new StringTokenizer(br.readLine());
		StringTokenizer cst = new StringTokenizer(br.readLine());
		int maxCost = 1;
		for(int n = 0; n < num; n++) {
			appArr[n] = new int[] {Integer.parseInt(mst.nextToken()), Integer.parseInt(cst.nextToken())};
			maxCost += appArr[n][1];
		}
		int[][] dp = new int[num+1][maxCost];
		for(int n = 0; n < num; n++) {
			for(int c = 0; c < appArr[n][1]; c++) dp[n+1][c] = dp[n][c];
			for(int c = appArr[n][1]; c < maxCost; c++) dp[n+1][c] = Math.max(dp[n][c], dp[n][c - appArr[n][1]] + appArr[n][0]);
		}
		int answer = -1;
		for(int j = 0; j < dp[dp.length-1].length; j++) {
			if(dp[dp.length-1][j] >= M) {
				answer = j;
				break;
			}
		}
		System.out.println(answer);
	}
}
