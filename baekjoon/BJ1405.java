import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1405 {
	private static int N;
	private static double[] percentage;
	private static boolean[][] vis = new boolean[29][29];
	private static int[] dr = new int[] {0, 0, 1, -1};
	private static int[] dc = new int[] {1, -1, 0, 0};
	private static double simple = 0;
	
	private static void search(int r, int c, int depth, double per) {
		if(vis[r][c]) return;
		if(depth == N) {
			simple += per;
			return;
		}
		vis[r][c] = true;
		for(int d = 0; d < 4; d++) {
			search(r + dr[d], c + dc[d], depth + 1, per * percentage[d]);
		}
		vis[r][c] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		percentage = new double[] {
				Integer.parseInt(st.nextToken()) / 100., 
				Integer.parseInt(st.nextToken()) / 100., 
				Integer.parseInt(st.nextToken()) / 100., 
				Integer.parseInt(st.nextToken()) / 100.};
		search(14, 14, 0, 1);
		System.out.println(simple);
	}
}
