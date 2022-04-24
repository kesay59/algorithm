import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] >= S) {
				System.out.println(1);
				return;
			}
		}
		int beforeIdx = 0, afterIdx = 0, answer = Integer.MAX_VALUE;
		long sum = 0;
		while(true) {
			if(sum >= S) {
				sum -= arr[beforeIdx++];
			} else {
				if(afterIdx >= N) break;
				sum += arr[afterIdx++];
			}
			if(sum >= S) answer = Math.min(answer, afterIdx - beforeIdx);
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}