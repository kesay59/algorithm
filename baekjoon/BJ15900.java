import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ15900 {
	private static HashSet<Integer>[] arr;
	private static int sum = 0;
	
	private static void search(int parent, int cur, int dp) {
		arr[cur].remove(parent);
		if(arr[cur].isEmpty()) {
			sum += dp;
			return;
		}
		for(int c : arr[cur]) {
			search(cur, c, dp+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new HashSet[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = new HashSet<Integer>();
		}
		StringTokenizer st;
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		search(0, 1, 0);
		if(sum % 2 == 1) System.out.println("Yes");
		else System.out.println("No");
	}
}
