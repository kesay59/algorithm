import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 7562 나이트의 이동
public class BJ7562 {

	private static class Point {
		int r, c;
		int cnt;

		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		@Override
		public boolean equals(Object obj) {
			Point p = (Point)obj;
			return this.r == p.r && this.c == p.c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dr = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dc = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
		int tcN = Integer.parseInt(br.readLine());
		StringTokenizer st;
		out : for (int tc = 0; tc < tcN; tc++) {
			int len = Integer.parseInt(br.readLine());
			int map[][] = new int[len][len];
			boolean[][] vis = new boolean[len][len];
			Queue<Point> que = new LinkedList<Point>();
			st = new StringTokenizer(br.readLine());
			que.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			while(!que.isEmpty()) {
				Point cur = que.poll();
				if(cur.equals(end)) {
					System.out.println(cur.cnt);
					continue out;
				}
				for(int k = 0 ; k < 8; k++) {
					int r = cur.r + dr[k];
					int c = cur.c + dc[k];
					try {
						if(!vis[r][c]) {
							que.add(new Point(r, c, cur.cnt + 1));
							vis[r][c] = true;
						}
					} catch(ArrayIndexOutOfBoundsException e) {}
				}
			}
		}
	}

}
