import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20040 {
	private static int[] parent;
	private static int findParent(int c) {
		if(parent[c] != c) parent[c] = findParent(parent[c]);
		return parent[c];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		for(int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		int a, b, ap, bp;
		for(int j = 1; j <= m; j++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ap = findParent(a);
			bp = findParent(b);
			if(ap == bp) {
				System.out.println(j);
				return;
			}
			parent[b] = a;
		}
		System.out.println(0);
	}
}
