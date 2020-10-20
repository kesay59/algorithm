import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BJ 16174 젤리(Large)
public class BJ16174 {

	private static int[][] map;
	private static boolean[][] vis;
	private static int len;
	
	private static void move(int r, int c) {
		if(r >= len || c >= len) return;
		if(vis[r][c]) return;
		if(r == len-1 && c == len-1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		vis[r][c] = true;
		move(r+map[r][c], c);
		move(r, c+map[r][c]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		map = new int[len][len];
		vis = new boolean[len][len];
		for(int i = 0; i < len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < len; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		move(0, 0);
		System.out.println("Hing");

	}

}
