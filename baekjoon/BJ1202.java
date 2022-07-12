import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] jewels = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i][0] = Integer.parseInt(st.nextToken());
			jewels[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(jewels, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int[] bags = new int[K];
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		int idx = 0;
		long sum = 0;
		for(int b = 0; b < bags.length; b++) {
			for(; idx < jewels.length; idx++) {
				if(jewels[idx][0] > bags[b]) break;
				pq.offer(jewels[idx]);
			}
			if(!pq.isEmpty()) sum += pq.poll()[1];
		}
		System.out.println(sum);
	}
}
