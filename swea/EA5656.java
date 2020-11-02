import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 5656 벽돌 깨기
public class EA5656 {

	private static int width, height, shot, answer;
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	
	
	private static void copy(int[][][] map, int[][] lim, int dp) {
		for(int w = 0; w < width; w++) {
			for(int h = height - 1; h > lim[dp-1][w]; h--) {
				map[dp][h][w] = map[dp-1][h][w];
			}
		}
	}
	
	private static void del(int[][][] map, int[][] lim, int dp, int r, int c) {
		if(c < 0 || c >= width || r >= height || r <= lim[dp-1][c] || map[dp][r][c] == 0) return;
		int cnt = map[dp][r][c];
		map[dp][r][c] = 0;
		for(int i = 1; i < cnt; i++) {
			for(int k = 0; k < 4; k++) {
				del(map, lim, dp, r+dr[k]*i, c+dc[k]*i);
			}
		}
	}
	
	private static void fall(int[][][] map, int[][] lim, int dp) {
		for(int w = 0; w < width; w++) {
			int cur = height - 1;
			for(int h = height - 1; h > lim[dp-1][w]; h--) {
				if(map[dp][h][w] != 0) map[dp][cur--][w] = map[dp][h][w];
			}
			lim[dp][w] = cur;
		}
	}
	
	private static void dfs(int[][][] map, int[][] lim, int dp) {
		if(dp > shot) {
			int sum = 0;
			for(int v : lim[dp-1])
				sum += height - v - 1;
			answer = Math.min(answer, sum);
			return;
		}
		for(int w = 0; w < width; w++) {
			copy(map, lim, dp);
			del(map, lim, dp, lim[dp-1][w] + 1, w);
			fall(map, lim, dp);
			dfs(map, lim, dp+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcN = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= tcN; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			shot = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			int[][][] map = new int[shot+1][height][width];
			int[][] lim = new int[shot+1][width];
			for(int i = 0; i < height; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < width; j++) {
					map[0][i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int w = 0; w < width; w++) {
				int cur = height - 1;
				for(int h = height - 1; h > -1; h--) {
					if(map[0][h][w] != 0) map[0][cur--][w] = map[0][h][w];
				}
				lim[0][w] = cur;
			}
			dfs(map, lim, 1);
            
			System.out.println("#" + tc + " " + answer);
		}
		

	}

}
