import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1309 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[][] arr = new int[N][3];
		Arrays.fill(arr[0], 1);
		for(int n = 1; n < N; n++) {
			arr[n][0] = (arr[n-1][1] + arr[n-1][2]) % 9901;
			arr[n][1] = (arr[n-1][0] + arr[n-1][2]) % 9901;
			arr[n][2] = (arr[n-1][0] + arr[n-1][1] + arr[n-1][2]) % 9901;
		}
		System.out.println((arr[N-1][0] + arr[N-1][1] + arr[N-1][2]) % 9901);
	}
}
