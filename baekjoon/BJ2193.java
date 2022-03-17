import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		long[][] arr = new long[][] {{0, 1}, {0, 0}};
		int flag = 1;
		for(int i = 1; i < num; i++) {
			arr[flag][0] = arr[flag^1][0] + arr[flag^1][1];
			arr[flag][1] = arr[flag^1][0];
			flag^=1;
		}
		System.out.println(arr[flag^1][0] + arr[flag^1][1]);
	}
}
