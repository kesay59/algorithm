import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ23843 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {			
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		long[] arr = new long[M];
		while(!pq.isEmpty()) {
			int minIdx = 0;
			for(int idx = 0; idx < arr.length; idx++) {
				if(arr[idx] < arr[minIdx]) minIdx = idx;
			}
			arr[minIdx] += pq.poll();
		}
		long maxValue = 0;
		for(long val : arr) {
			maxValue = maxValue > val ? maxValue : val;
		}
		System.out.println(maxValue);
	}
}
