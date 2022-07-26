import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717 {
	private static int[] parent;
	private static int find(int p) {
		if(p == parent[p]) return p;
		parent[p] = find(parent[p]);
		return parent[p];
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		parent[pb] = pa; 
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int n = 0; n <= N; n++) {
			parent[n] = n;
		}
		StringBuilder stb = new StringBuilder();
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			if("0".equals(st.nextToken())) {
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} else {
				if(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))) {
					stb.append("YES\n");
				} else {
					stb.append("NO\n");
				}
			}
		}
		System.out.println(stb.toString());
	}
}
