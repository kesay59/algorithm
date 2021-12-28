import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ23814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long D = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long max, min;
		if(N % D > M % D) {
			max=N; 
			min=M;
		} else {
			max=M;
			min=N;
		}
		
		PriorityQueue<long[]> pq = new PriorityQueue<long[]>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[0] == o2[0]) return o2[1] > o1[1] ? 1 : -1;
				return o2[0] > o1[0] ? 1 : -1;
			}
		});
		pq.offer(new long[] {K / D, K});
		if(K >= D - max % D) {
			long rem = K - (D - max % D);
			pq.offer(new long[] {rem / D + 1, rem});
		}
		if(K >= (D - max % D) + (D - min % D)) {
			long rem = K - ((D - max % D) + (D - min % D));
			pq.offer(new long[] {rem / D + 2, rem});
		}
		System.out.println(pq.poll()[1]);
	}
}
