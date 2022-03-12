import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		for(int r = 0; r < row; r++) {
			map[r] = br.readLine().toCharArray();
		}
		int[] to = new int[2];
		int[] from = new int[2];
		List<int[]> waterStart = new ArrayList<int[]>();
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(map[r][c] == 'D') {
					to[0] = r;
					to[1] = c;
				} else if(map[r][c] == 'S') {
					from[0] = r;
					from[1] = c;
				} else if(map[r][c] == '*') {
					waterStart.add(new int[] {r, c, 0});
				}
			}
		}
		int[] dr = new int[] {-1, 0, 1, 0};
		int[] dc = new int[] {0, -1, 0, 1};
		int[][] water = new int[row][col];
		for(int r = 0; r < row; r++) {
			Arrays.fill(water[r], Integer.MAX_VALUE);
		}
		Queue<int[]> que = new LinkedList<int[]>();
		for(int[] ws : waterStart) {
			que.offer(ws);
		}
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(water[cur[0]][cur[1]] <= cur[2]) continue;
			water[cur[0]][cur[1]] = cur[2];
			int nextR, nextC;
			for(int d = 0; d < 4; d++) {
				nextR = cur[0] + dr[d];
				nextC = cur[1] + dc[d];
				if(nextR < 0 || nextR >= row || nextC < 0 || nextC >= col || map[nextR][nextC] == 'X' || map[nextR][nextC] == 'D') continue;
				que.offer(new int[] {nextR, nextC, cur[2] + 1});
			}
		}
		water[to[0]][to[1]] = Integer.MAX_VALUE;

		int[][] moving = new int[row][col];
		que.offer(new int[] {from[0], from[1], 0});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(map[cur[0]][cur[1]] == 'D') {
				System.out.println(cur[2]);
				System.exit(0);
			}
			if(moving[cur[0]][cur[1]] != 0 || water[cur[0]][cur[1]] <= cur[2]) continue;
			moving[cur[0]][cur[1]] = cur[2];
			int nextR, nextC;
			for(int d = 0; d < 4; d++) {
				nextR = cur[0] + dr[d];
				nextC = cur[1] + dc[d];
				if(nextR < 0 || nextR >= row || nextC < 0 || nextC >= col || map[nextR][nextC] == 'X') continue;
				que.offer(new int[] {nextR, nextC, cur[2] + 1});
			}
		}
		System.out.println("KAKTUS");
	}
}
