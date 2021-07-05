import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {

	private static class Move {
		int r, c;
		int dp;
		boolean br;

		Move(int r, int c, int dp, boolean br) {
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
		char[][] map = new char[row][col];
		vis = new boolean[row][col][2];

		for (int i = 0; i < row; i++)
			map[i] = br.readLine().toCharArray();

		Queue<Move> que = new LinkedList<Move>();
		que.offer(new Move(0, 0, 0, false));
		while (!que.isEmpty()) {
			Move cur = que.poll();
			if (cur.r == row - 1 && cur.c == col - 1) {
				System.out.println(cur.dp + 1);
				return;
			}
			for (int k = 0; k < 4; k++) {
				try {
					if (map[cur.r + dr[k]][cur.c + dc[k]] == 48) {
						if (!cur.br) {
							if (!vis[cur.r + dr[k]][cur.c + dc[k]][0]) {
								que.add(new Move(cur.r + dr[k], cur.c + dc[k], cur.dp + 1, false));
								vis[cur.r + dr[k]][cur.c + dc[k]][0] = true;
							}
						} else {
							if (!vis[cur.r + dr[k]][cur.c + dc[k]][1] && !vis[cur.r + dr[k]][cur.c + dc[k]][0]) {
								que.add(new Move(cur.r + dr[k], cur.c + dc[k], cur.dp + 1, true));
								vis[cur.r + dr[k]][cur.c + dc[k]][1] = true;
							}
						}
					} else {
						if (!cur.br) {
							if (!vis[cur.r + dr[k]][cur.c + dc[k]][0]) {
								que.add(new Move(cur.r + dr[k], cur.c + dc[k], cur.dp + 1, true));
								vis[cur.r + dr[k]][cur.c + dc[k]][0] = true;
							}
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {}
			}
		}
		System.out.println(-1);
	}
}