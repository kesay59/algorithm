import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4963 {

	private static int[] dr = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] dc = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	private static int[][] map;
	private static boolean[][] visited;

	static void find(int i, int j) {
		visited[i][j] = true;
		int k = 0;
		for (; k < 8; k++) {
			try {
				if (!visited[i + dr[k]][j + dc[k]]) {
					if (map[i + dr[k]][j + dc[k]] == 1)
						find(i + dr[k], j + dc[k]);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			
			int cnt = 0;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) 
					if(map[i][j] == 1 && !visited[i][j]) {
						find(i, j);
						cnt++;
					}
			}
			System.out.println(cnt);
		}
		

	}

}
