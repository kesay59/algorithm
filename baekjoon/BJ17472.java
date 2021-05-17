import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 17472 다리 만들기 2
public class BJ17472 {

	static class Edge implements Comparable<Edge>{
		int to, w;
		
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int[] dr = new int[] {-1, 0, 0, 1};
	static int[] dc = new int[] {0, -1, 1, 0};
	static int col, row;
	
	private static void findIsland(char[][] map, int i, int j, char sig) {
		boolean[][] vis = new boolean[row][col];
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {i, j});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			map[cur[0]][cur[1]] = sig;
			vis[cur[0]][cur[1]] = true;
			for(int k = 0; k < 4; k++) {
				try {
					if(map[cur[0] + dr[k]][cur[1] + dc[k]] == 49 && !vis[cur[0] + dr[k]][cur[1] + dc[k]]) 
						que.offer(new int[] {cur[0] + dr[k], cur[1] + dc[k]});
				}catch(ArrayIndexOutOfBoundsException e) {}
			}
		}
	}
	
	private static void makeBridge(char[][] map, int i, int j, int[][] leng) {
		for(int k = 0; k < 4; k++) {
			try {
				if(map[i + dr[k]][j + dc[k]] == 48) {
					int r = i + dr[k];
					int c = j + dc[k];
					int dp = 0;
					while(map[r][c] == 48) {
						r += dr[k];
						c += dc[k];
						dp++;
					}
					if(dp > 1) leng[map[i][j]][map[r][c]] = Math.min(leng[map[i][j]][map[r][c]], dp);
				}
			} catch(ArrayIndexOutOfBoundsException e) {}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		for(int i = 0; i < row; i++)
			map[i] = br.readLine().replace(" ", "").toCharArray();
		char sig = 0;
		for(int i = 0; i < row; i++) 
			for(int j = 0; j < col; j++) 
				if(map[i][j] == 49) findIsland(map, i, j, sig++);
		int[][] leng = new int[sig][sig];
		for(int i = 0; i < sig; i++) {
			Arrays.fill(leng[i], Integer.MAX_VALUE);
			leng[i][i] = 0;
		}
		for(int i = 0; i < row; i++) 
			for(int j = 0; j < col; j++) 
				if(map[i][j] != 48) makeBridge(map, i, j, leng);
		
		int sum = 0;
		boolean[] vis = new boolean[sig];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(vis[cur.to]) continue;
			sum += cur.w;
			vis[cur.to] = true;
			for(int i = 0; i < sig; i++) {
				if(leng[cur.to][i] != Integer.MAX_VALUE && i != cur.to)
					pq.offer(new Edge(i, leng[cur.to][i]));
			}
		}
		boolean flag = true;
		for(boolean v : vis)
			if(!v) flag = false;
		if(sum == 0) flag = false;
		if(flag) System.out.println(sum);
		else System.out.println(-1);
	}
}
