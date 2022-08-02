import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13975 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for(int n = 0; n < N; n++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			long sum = 0;
			long cur;
			while(pq.size() > 1) {
				cur = pq.poll() + pq.poll();
				sum += cur;
				pq.offer(cur);
			}
			System.out.println(sum);
		}
	}
}