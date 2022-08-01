import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> arr = new HashMap<>();
		int sum = 0;
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for(int idx = 0; idx < N; idx++) {
			sum += Integer.parseInt(st.nextToken());
			if(sum == M) cnt++;
			else if(sum > M) if(arr.containsKey(sum - M)) cnt += arr.get(sum - M);
			if(arr.containsKey(sum)) arr.put(sum, arr.get(sum) + 1);
			else arr.put(sum, 1);
		}
		System.out.println(cnt);
	}
}
