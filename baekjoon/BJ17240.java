import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ17240 {
	private static int maxValue = 0;
	private static int[] selected = new int[5];
	private static void find(int[][][] arr, int idx, int sum) {
		if(idx == 5) {
			maxValue = Math.max(maxValue, sum);
			return;
		}
		out : for(int n = 0; n < 5; n++) {
			for(int i = 0; i < idx; i++) {
				if(arr[idx][n][0] == selected[i]) continue out;
			}
			selected[idx] = arr[idx][n][0];
			find(arr, idx + 1, sum + arr[idx][n][1]);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq[] = new PriorityQueue[5];
		for(int p = 0; p < 5; p++) {
			pq[p] = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
		}
		StringTokenizer st;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int p = 0; p < 5; p++) {
				pq[p].offer(new int[] {n, Integer.parseInt(st.nextToken())});
				if(pq[p].size() > 5) pq[p].poll();
			}
		}
		int[][][] arr = new int[5][5][];
		for(int p = 0; p < 5; p++) {
			for(int q = 0; q < 5; q++) {
				arr[p][q] = pq[p].poll();
			}
		}
		find(arr, 0, 0);
		System.out.println(maxValue);
	}
}
