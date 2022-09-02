import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16437 {
	private static long[] group;
	private static int[] parent;
	private static int[] conn;
	private static void union(int from, int to) {
		int pa = find(to);
		int pb = find(from);
		parent[pb] = pa;
		group[pa] += group[pb];
	}
	private static int find(int idx) {
		if(parent[idx] == idx) return idx;
		parent[idx] = find(parent[idx]);
		return parent[idx];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		group = new long[N+1];
		parent = new int[N+1];
		conn = new int[N+1];
		for(int n = 1; n <= N; n++) {
			parent[n] = n;
		}
		for(int n = 2; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			group[n] += st.nextToken().charAt(0) == 'S' ? Integer.parseInt(st.nextToken()) : -Integer.parseInt(st.nextToken());
			conn[n] = Integer.parseInt(st.nextToken());
			int cur = n;
			while(group[cur] >= 0 && cur <= n && parent[cur] == cur && cur != 1) {
				union(cur, conn[cur]);
				cur = find(cur);
			}
		}
		System.out.println(group[1]);
	}
}
// 섬의 양 수가 0보다 크거나 같아지면 재귀적으로 union
