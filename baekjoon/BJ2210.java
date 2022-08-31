import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ2210 {
	private static char[][] map = new char[5][5];
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	private static char[] arr = new char[6];
	private static Set<String> hs = new HashSet<>();
	
	private static void dfs(int r, int c, int depth) {
		if(depth == 6) {
			hs.add(new String(arr));
			return;
		}
		arr[depth] = map[r][c];
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
			dfs(nr, nc, depth + 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dfs(i, j, 0);
			}
		}
		System.out.println(hs.size());
	}
}
