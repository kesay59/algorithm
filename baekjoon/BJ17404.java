import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][][] memo = new int[3][num][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int c = 0; c < 3; c++) {
			memo[c][0][c] = Integer.parseInt(st.nextToken());
			memo[c][0][(c+1)%3] = Integer.MAX_VALUE / 2;
			memo[c][0][(c+2)%3] = Integer.MAX_VALUE / 2;
		}
		int[] cost = new int[3];
		for(int n = 1; n < num; n++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 3; c++) {
				cost[c] = Integer.parseInt(st.nextToken());
			}
			for(int firstColor = 0; firstColor < 3; firstColor++) {
				for(int color = 0; color < 3; color++) {					
					memo[firstColor][n][color] = cost[color] + Math.min(memo[firstColor][n-1][(color+1)%3], memo[firstColor][n-1][(color+2)%3]);
				}
			}
		}
		int minCost = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == j) continue;
				if(minCost > memo[i][num-1][j]) minCost = memo[i][num-1][j];
			}
		}
		System.out.println(minCost);
	}
}
