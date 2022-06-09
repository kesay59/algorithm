import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[num][];
		for(int i = 0; i < num; i++) {			
			st = new StringTokenizer(br.readLine());
			arr[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		int sum = 0;
		int idx = 0;
		int cur  = arr[idx][0];
		while(cur > 0) {
			while(idx < arr.length && arr[idx][0] == cur) {
				pq.offer(arr[idx]);
				idx++;
			}
			if(!pq.isEmpty()) sum += pq.poll()[1];
			cur--;
		}
		System.out.println(sum);
	}
}
