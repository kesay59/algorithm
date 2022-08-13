import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17398 {
	private static int[] group;
	private static long[] cnt;
	
	private static long union(int a, int b) {
		int groupA = find(a);
		int groupB = find(b);
		long cost = 0;
		if(groupA != groupB) {
			cost = getCnt(a) * getCnt(b);
			group[groupB] = groupA;
			cnt[groupA] += cnt[groupB];
		}
		return cost;
	}
	
	private static long getCnt(int idx) {
		return cnt[find(idx)];
	}
	
	private static int find(int idx) {
		if(group[idx] != idx) group[idx] = find(group[idx]);
		return group[idx];
	}
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		group = new int[N+1];
		for(int i = 1; i <= N; i++) {
			group[i] = i;
		}
		cnt = new long[N+1];
		Arrays.fill(cnt, 1);
		
		int[][] arr = new int[M+1][2];
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			arr[m][0] = Integer.parseInt(st.nextToken());
			arr[m][1] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] disconnect = new boolean[M+1];
		int[] cut = new int[Q];
		for(int q = Q-1; q >= 0; q--) {
			cut[q] = Integer.parseInt(br.readLine());
			disconnect[cut[q]] = true;
		}
		
		for(int m = 1; m <= M; m++) {
			if(!disconnect[m]) union(arr[m][0], arr[m][1]);
		}
		
		long sum = 0;
		for(int q = 0; q < Q; q++) {
			sum += union(arr[cut[q]][0], arr[cut[q]][1]);
		}
		System.out.println(sum);
	}
}
