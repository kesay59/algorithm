import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BJ 1197 최소 스패닝 트리
public class Main {

	private static int[] par;

	private static int find(int x) {
		if (par[x] == x)
			return x;
		else
			return par[x] = find(par[x]);
	}

	private static boolean union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if (a == b)
			return false;
		par[a] = b;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		par = new int[v + 1];
		Line[] ll = new Line[e];
		int cnt = 0;
		long sum = 0;

		for (int i = 1; i < par.length; i++)
			par[i] = i;

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			ll[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(ll);

		for (int i = 0; i < e; i++) {
			if (union(ll[i].v1, ll[i].v2)) {
				sum += ll[i].h;
				if (++cnt == v - 1)
					break;
			}
		}

		System.out.println(sum);
	}
}

class Line implements Comparable<Line>{
	int v1, v2, h;

	Line(int v1, int v2, int h) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.h = h;
	}
	
	@Override
	public int compareTo(Line o) {
		return Integer.compare(this.h, o.h);
	}

}
