import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BJ 2636 치즈
public class BJ2636 {

	private static class Air {
		int r, c;

		Air(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static int[] dr = new int[] { -1, 0, 0, 1 };
	private static int[] dc = new int[] { 0, -1, 1, 0 };
	private static int[][] map;
	private static int row, col, cntT, cntC, preCnt;
	private static boolean[][] vis;

	private static void fillAir(Air air) {
		if (air.r < 0 || air.r >= row || air.c < 0 || air.c >= col)
			return;
		if (map[air.r][air.c] == 1)
			return;
		if (map[air.r][air.c] == 2)
			return;
		map[air.r][air.c] = 2;
		for (int k = 0; k < 4; k++)
			fillAir(new Air(air.r + dr[k], air.c + dc[k]));
	}

	private static void searchAir(Air pre, Air cur) {
		if (cur.r < 0 || cur.r >= row || cur.c < 0 || cur.c >= col)
			return;
		if (map[cur.r][cur.c] == 1)
			return;
		if (map[cur.r][cur.c] == 2)
			fillAir(pre);
		if (vis[cur.r][cur.c])
			return;
		vis[cur.r][cur.c] = true;
		for (int k = 0; k < 4; k++)
			searchAir(cur, new Air(cur.r + dr[k], cur.c + dc[k]));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		vis = new boolean[row][col];
		cntC = 0;
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cntC++;
			}
		}
		
		fillAir(new Air(0, 0));
		
		cntT = 0;
		while (true) {
			ArrayList<Air> tmp = new ArrayList<>();
			for (int i = 0; i < row; i++)
				for (int j = 0; j < col; j++)
					if (map[i][j] == 1) {
						for (int k = 0; k < 4; k++) {
							if (i + dr[k] < 0 || i + dr[k] >= row || j + dc[k] < 0 || j + dc[k] >= col) continue;
							if (map[i + dr[k]][j + dc[k]] == 2) {
								tmp.add(new Air(i, j));
								break;
							}
						}
					}
			for (Air a : tmp)
				map[a.r][a.c] = 2;
			if (tmp.size() == 0) {
				System.out.println(cntT + "\n" + preCnt);
				break;
			}
			cntT++;
			preCnt = cntC;
			cntC = 0;
			vis = new boolean[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == 1)
						cntC++;
					if (map[i][j] == 0)
						searchAir(new Air(i, j), new Air(i, j));
				}
			}
			
		}

	}

}
