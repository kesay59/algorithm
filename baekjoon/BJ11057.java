import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[num+1][10];
		Arrays.fill(arr[0], 1);
		for(int i = 1; i < num; i++) {
			arr[i][0] = 1;
			for(int j = 1; j < 10; j++) {
				arr[i][j] = (arr[i][j-1] + arr[i-1][j]) % 10007;
			}
		}
		int sum = 0;
		for(int j = 0; j < 10; j++) {
			sum = (sum + arr[num-1][j]) % 10007;
		}
		System.out.println(sum);
	}
}
