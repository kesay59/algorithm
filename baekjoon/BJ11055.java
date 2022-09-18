import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		int[] sum = new int[N];
		for(int n = 0; n < N; n++) {
			int prev = 0;
			for(int p = n - 1; p >= 0; p--) {
				if(arr[p] < arr[n]) {
					prev = Math.max(prev, sum[p]);
				}
			}
			sum[n] = prev + arr[n];
		}
		int answer = 0;
		for(int n = 0; n < N; n++) {
			answer = Math.max(answer, sum[n]);
		}
		System.out.println(answer);
	}
}
