import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1106 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] memo = new int[100001];
		int target, value;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			target = Integer.parseInt(st.nextToken());
			value = Integer.parseInt(st.nextToken());
			memo[target] = Math.max(memo[target], value);
		}
		int sta, end;
		for(int k = 1; k < 100001; k++) {
			sta = 1;
			end = k - 1;
			while(sta <= end) {
				memo[k] = Math.max(memo[k], memo[sta] + memo[end]);
				sta++;
				end--;
			}
			if(memo[k] >= C) {
				System.out.println(k);
				return;
			}
		}
	}
}
