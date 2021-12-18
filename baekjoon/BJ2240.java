import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2240 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][][] plumArr = new int[3][T+1][W+1];
		
		int loc = Integer.parseInt(br.readLine());
		if(loc == 1) plumArr[1][1][0] = 1;
		else plumArr[2][1][1] = 1;
		for(int t = 2; t <= T; t++) {
			loc = Integer.parseInt(br.readLine());
			for(int w = 0; w <= t && w <= W; w++) {
				if(w == 0) {
					plumArr[1][t][w] = plumArr[1][t-1][w];
					plumArr[2][t][w] = plumArr[2][t-1][w];
				}
				else {
					plumArr[1][t][w] = Math.max(plumArr[1][t-1][w], plumArr[2][t-1][w-1]);
					plumArr[2][t][w] = Math.max(plumArr[2][t-1][w], plumArr[1][t-1][w-1]);
				}
				plumArr[loc][t][w]++;
			}
		}
		int max = 0;
		for(int w = 0; w <= T && w <= W; w++) {
			for(int k = 1; k <= 2; k++) {				
				max = Math.max(max, plumArr[k][T][w]);
			}
		}
		System.out.println(max);
	}
}
