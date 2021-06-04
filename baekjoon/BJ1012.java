import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1012 {
	
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	private static int row, col;
	private static int[][] map;
	
	
	private static void search(int r, int c) {
		if(r < 0 || r >= row || c < 0 || c >= col) return;
		if(map[r][c] == 1) {
			map[r][c] = 0;
			for(int t = 0; t < 4; t++) {
				search(r + dr[t], c + dc[t]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			map = new int[row][col];
			
			for(int c = 0; c < cnt; c++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			int answer = 0;
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(map[i][j] == 1) {
						answer++;
						search(i, j);
					}
				}
			}
			System.out.println(answer);
		}
	}
}
