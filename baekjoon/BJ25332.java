import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ25332 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		StringTokenizer stB = new StringTokenizer(br.readLine());

		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(stA.nextToken()) - Integer.parseInt(stB.nextToken());
		}
		Map<Long, Integer> hm = new HashMap<>();
		long sum = 0;
		long cnt = 0;
		for(int n = 0; n < N; n++) {
			sum += arr[n];
			if(sum == 0) cnt++;
			if(hm.containsKey(sum)) {
				cnt += hm.get(sum);
				hm.put(sum, hm.get(sum) + 1);
			}
			else {
				hm.put(sum, 1);
			}
		}
		System.out.println(cnt);
	}
}
