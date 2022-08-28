import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1421 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		long maxValue = 0;
		for(int k = 1; k <= 10000; k++) {
			long sum = 0;
			for(int n = 0; n < N; n++) {
				int price = 0;
				if(k == arr[n]) {
					price = arr[n] * W;
				} else if(k < arr[n]) {
					int tmp = 0;
					tmp = arr[n] / k * k * W;
					if(arr[n] % k == 0) {
						tmp -= (arr[n] / k - 1) * C;
					} else {
						tmp -= arr[n] / k * C;
					}
					price = Math.max(price, tmp);
				}
				sum += price;
			}
			maxValue = Math.max(maxValue, sum);
		}
		System.out.println(maxValue);
	}
}
