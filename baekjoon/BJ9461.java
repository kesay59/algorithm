import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9461 {
	public static void main(String[] args) throws IOException {
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for(int i = 4; i < 101; i++) {
			arr[i] = arr[i-3] + arr[i-2];
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder stb = new StringBuilder();
		for(int t = 0; t < tc; t++) {
			stb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.println(stb);
	}
}
