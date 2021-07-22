import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ19238 {

	private static class Spot implements Comparable<Spot> {
		int r, c, dp;

		public Spot(int r, int c) {
			this.r = r;
			this.c = c;
			this.dp = 0;
		}

		public Spot(int r, int c, int dp) {
			this.r = r;
			this.c = c;
			this.dp = dp;
		}

		@Override
		public int compareTo(Spot o) {
			if (this.dp != o.dp)
				return this.dp - o.dp;
			if (this.r != o.r)
				return this.r - o.r;
			return this.c - o.c;
		}

		@Override
		public boolean equals(Object obj) {
			Spot o = (Spot) obj;
			if (o.r == this.r && o.c == this.c)
				return true;
			return false;
		}

	}

	private static int[] dr = new int[] { -1, 0, 1, 0 };
	private static int[] dc = new int[] { 0, 1, 0, -1 };

	private static Spot search(char[][] map, Spot start, char tg, int oil) {
		PriorityQueue<Spot> pq = new PriorityQueue<>();
		pq.offer(start);
		boolean[][] vis = new boolean[map.length][map[0].length];
		while (!pq.isEmpty()) {
			Spot sp = pq.poll();
			if (vis[sp.r][sp.c] || map[sp.r][sp.c] == 49)continue;
			vis[sp.r][sp.c] = true;
			if (map[sp.r][sp.c] == tg) {
				map[sp.r][sp.c] = 0;
				return sp;
			}
			if (sp.dp >= oil)
				continue;
			for (int k = 0; k < 4; k++)
				pq.offer(new Spot(sp.r + dr[k], sp.c + dc[k], sp.dp + 1));
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int oil = Integer.parseInt(st.nextToken());
		char[][] map = new char[len + 2][];
		map[0] = new char[len + 2];
		map[len + 1] = new char[len + 2];
		for (int i = 0; i < len + 2; i++) {
			map[0][i] = map[len + 1][i] = 49;
		}
		for (int i = 1; i <= len; i++)
			map[i] = ("1" + br.readLine().replace(" ", "") + "1").toCharArray();
		st = new StringTokenizer(br.readLine());
		Spot start = new Spot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Spot[][] arr = new Spot[num][2];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = new Spot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			map[arr[i][0].r][arr[i][0].c] = 50;
			arr[i][1] = new Spot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int n = 0; n < num; n++) {
			start = search(map, start, '2', oil);
			if (start == null) {
				System.out.println(-1);
				System.exit(0);
			}
			oil -= start.dp;
			start.dp = 0;
			map[start.r][start.c] = 48;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][0].equals(start)) {
					char tmp = map[arr[i][1].r][arr[i][1].c];
					map[arr[i][1].r][arr[i][1].c] = 51;
					
					start = search(map, start, '3', oil);
					if (start == null) {
						System.out.println(-1);
						System.exit(0);
					}
					oil += start.dp;
					map[start.r][start.c] = 48;
					start.dp = 0;
					
					map[arr[i][1].r][arr[i][1].c] = tmp;
					break;
				}
			}
		}
		System.out.println(oil);
	}

}
