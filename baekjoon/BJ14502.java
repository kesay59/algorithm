import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {
	private static int row;
	private static int col;
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	private static int[][] map;
	private static int minCnt = Integer.MAX_VALUE;
	
	private static void spread(boolean[][] simulMap, List<int[]> virus) {
		int cnt = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		for(int[] v : virus) {
			que.offer(v);
		}
		int[] cur;
		while(!que.isEmpty()) {
			cur = que.poll();
			if(simulMap[cur[0]][cur[1]]) continue;
			
			simulMap[cur[0]][cur[1]] = true;
			if(++cnt >= minCnt) return;
			int nr, nc;
			for(int d = 0; d < 4; d++) {
				nr = cur[0] + dr[d];
				nc = cur[1] + dc[d];
				if(nr >= 0 && nr < row && nc >= 0 && nc < col && map[nr][nc] != 1 && !simulMap[nr][nc]) {
					que.offer(new int[] {nr, nc});
				}
			}
		}
		minCnt = cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		List<int[]> virus = new ArrayList<>();
		int zeroCnt = 0;
		for(int r = 0 ; r < row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) virus.add(new int[] {r, c});
				else if(map[r][c] == 0) zeroCnt++;
			}
		}
		int w1row, w2row, w3row, w1col, w2col, w3col;
		w1row = 0;
		w1col = 0;
		for(; w1row < row;) {
			if(map[w1row][w1col] == 0) {
				w2row = w1col == col - 1 ? w1row + 1 : w1row;
				w2col = w1col == col - 1 ? 0 : w1col + 1;
				for(; w2row < row;) {
					if(map[w2row][w2col] == 0) {
						w3row = w2col == col - 1 ? w2row + 1 : w2row;
						w3col = w2col == col - 1 ? 0 : w2col + 1;
						for(; w3row < row;) {
							if(map[w3row][w3col] == 0) {
								map[w1row][w1col] = 1;
								map[w2row][w2col] = 1;
								map[w3row][w3col] = 1;
								spread(new boolean[row][col], virus);
								map[w1row][w1col] = 0;
								map[w2row][w2col] = 0;
								map[w3row][w3col] = 0;
							}
							if(++w3col == col) {
								w3row++;
								w3col = 0;
							}			
						}
					}
					if(++w2col == col) {
						w2row++;
						w2col = 0;
					}			
				}
			}
			if(++w1col == col) {
				w1row++;
				w1col = 0;
			}			
		}
		System.out.println(zeroCnt + virus.size() - 3 - minCnt);
	}
}
