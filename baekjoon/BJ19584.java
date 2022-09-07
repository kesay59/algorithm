import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ19584 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] map = new int[N+1];
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			map[n] = Integer.parseInt(st.nextToken());
		}
		int[][] sta = new int[M][2];
		int[][] end = new int[M][2];
		int a, b;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sta[m][0] = Math.min(map[a], map[b]);
			end[m][0] = Math.max(map[a], map[b]);
			sta[m][1] = end[m][1] = Integer.parseInt(st.nextToken());
		}
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		};
		Arrays.sort(sta, comp);
		Arrays.sort(end, comp);
		int staIdx = 0, endIdx = 0;
		long sum = 0, maxSum = 0;
		while(true) {
			if(staIdx < M && endIdx < M) {
				if(sta[staIdx][0] <= end[endIdx][0]) {
					sum += sta[staIdx][1];
					staIdx++;
					maxSum = Math.max(maxSum, sum);
				} else {
					sum -= end[endIdx][1];
					endIdx++;
				}
			} else if(staIdx < M) {
				sum += sta[staIdx][1];
				staIdx++;
				maxSum = Math.max(maxSum, sum);
			} else if(endIdx < M){
				sum -= end[endIdx][1];
				endIdx++;
			} else {
				break;
			}
		}
		System.out.println(maxSum);
	}
}