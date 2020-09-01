package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준 1753 최단 거리
public class BJ1753 {

	static class Edge implements Comparable<Edge> {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vn = Integer.parseInt(st.nextToken());
		int en = Integer.parseInt(st.nextToken());
		int[] dist = new int[vn + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int start = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] arr = new ArrayList[vn + 1];
		for (int i = 1; i < vn + 1; i++)
			arr[i] = new ArrayList<Edge>();
		for (int i = 0; i < en; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())]
					.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		PriorityQueue<Edge> que = new PriorityQueue<Edge>();
		boolean[] vis = new boolean[vn + 1];
		for (Edge e : arr[start]) {
			que.offer(e);
		}
		dist[start] = 0;
		vis[start] = true;
		while (!que.isEmpty()) {
			Edge cur = que.poll();
			if(vis[cur.v]) continue;
			vis[cur.v] = true;
			dist[cur.v] = cur.w;
			for (Edge e : arr[cur.v]) {
				if (!vis[e.v]) {
					e.w += dist[cur.v];
					que.add(e);
				}
			}
		}
		for (int i = 1; i < vn + 1; i++)
			if (vis[i])
				System.out.println(dist[i]);
			else
				System.out.println("INF");
	}

}
