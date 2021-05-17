import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//백준 2468 안전 영역
public class BJ2468{

	private static int[] dr = new int[] {-1,0, 0,1};
	private static int[] dc = new int[] {0,-1, 1,0};
	private static int[][] map;
	private static boolean[][] visited;
	private static int ct, lim;
	private static int max = 1;

	static void find(int i, int j) {
		visited[i][j] = true;
		int k = 0;
		for (; k < 4; k++) {
			try {
				if (!visited[i + dr[k]][j + dc[k]]) {
					if (map[i + dr[k]][j + dc[k]] > lim)
						find(i + dr[k], j + dc[k]);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = w;
		HashSet<Integer> hs = new HashSet<Integer>();
		
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				hs.add(map[i][j]);
			}
		}
		
		
		for(int l : hs) {
			lim = l;
			visited = new boolean[h][w];
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++)
					if (map[i][j] > lim && !visited[i][j]) {
						find(i, j);
						cnt++;
					}
			}
			if(max < cnt) max = cnt;
		}
		
		System.out.println(max);

	}

}