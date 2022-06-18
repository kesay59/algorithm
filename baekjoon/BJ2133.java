import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2133 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if(N % 2 == 1) {
			System.out.println(0);
		} else {
			int n = N / 2;
			int[] memo = new int[n + 1];
			memo[0] = 1;
			for(int i = 1; i <= n; i++) {
				memo[i] = memo[i - 1] * 3;
				for(int j = 2; j <= i; j++) {
					memo[i] += memo[i - j] * 2; 
				}
			}
			System.out.println(memo[n]);
		}
	}
}
