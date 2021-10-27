import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ15903 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		long sum;
		for(int i = 0; i < M; i++) {
			sum = pq.poll() + pq.poll();
			pq.offer(sum);
			pq.offer(sum);
		}
		long ans = 0;
		while(!pq.isEmpty()) {
			ans += pq.poll();
		}
		System.out.println(ans);
	}

}
