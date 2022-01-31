import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[2][k+1];
		arr[0][0] = 1;
		arr[1][0] = 1;
		int flag = 0;
		for(int i = 0; i < n; i++) {
			int cur = Integer.parseInt(br.readLine());
			for(int idx = 1; idx <=k; idx++) {
				int sum = 0;
				for(int pre = idx - cur; pre >= 0; pre -= cur) {
					sum += arr[flag^1][pre];
				}
				arr[flag][idx] = arr[flag^1][idx] + sum;
			}
			flag ^= 1;
		}
		System.out.println(arr[flag^1][k]);
	}
}
