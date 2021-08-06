import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14442 {

	private static class Move {
		int r, c;
		int dp;
		int br;

		Move(int r, int c, int dp, int br) {
			this.r = r;
			this.c = c;
			this.dp = dp;
			this.br = br;
		}
	}

	private static boolean[][][] vis;
	private static int[] dr = new int[] { -1, 0, 1, 0 };
	private static int[] dc = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][col];
		vis = new boolean[row][col][lim + 1];

		for (int i = 0; i < row; i++)
			map[i] = br.readLine().toCharArray();

		Queue<Move> que = new LinkedList<Move>();
		que.offer(new Move(0, 0, 0, 0));
		while (!que.isEmpty()) {
			Move cur = que.poll();
			if (cur.r == row - 1 && cur.c == col - 1) {
				System.out.println(cur.dp + 1);
				return;
			}
			for (int k = 0; k < 4; k++) {
				try {
					int r = cur.r + dr[k];
					int c = cur.c + dc[k];
					if (cur.br < lim + 1) {
						// 빈공간
						if (map[r][c] == 48) {
							if (!vis[r][c][cur.br]) {
								que.add(new Move(cur.r + dr[k], cur.c + dc[k], cur.dp + 1, cur.br));
								for (int b = cur.br; b < lim + 1; b++)
									vis[r][c][b] = true;
							}
						}
						// 벽
						else {
							if (!vis[r][c][cur.br + 1]) {
								que.add(new Move(cur.r + dr[k], cur.c + dc[k], cur.dp + 1, cur.br + 1));
								for (int b = cur.br + 1; b < lim + 1; b++)
									vis[r][c][b] = true;
							}
						}
					} else {
						// 빈공간
						if (map[r][c] == 48) {
							if (!vis[r][c][cur.br]) {
								que.add(new Move(cur.r + dr[k], cur.c + dc[k], cur.dp + 1, cur.br));
								for (int b = cur.br; b < lim + 1; b++)
									vis[r][c][b] = true;
							}
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		System.out.println(-1);
	}
}