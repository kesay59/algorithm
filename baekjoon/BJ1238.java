import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

//BJ 1238 파티
public class BJ1238 {

	private static class Edge implements Comparable<Edge>{
		
		int from, to, w;
		
		Edge(int from, int to, int w){
			this.from = from;
			this.to = to;
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] edges = new ArrayList[N+1];
		for(int i = 1; i < N + 1; i++)
			edges[i] = new ArrayList<Edge>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(from, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int[][] dist = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			for(Edge e : edges[i])
				dist[e.from][e.to] = e.w;
		}
		for(int j = 1; j < N+1; j++) {
			for(int i = 1; i < N+1; i++) {
				if(dist[i][j] != Integer.MAX_VALUE) {
					for(int m = 1; m < N+1; m++) {
						if(dist[j][m] != Integer.MAX_VALUE)
							dist[i][m] = Math.min(dist[i][m], dist[i][j] + dist[j][m]);
					}
				}
			}
		}
		int answer = 0;
		for(int i = 1; i < N+1; i++) {
			if(i == goal) continue;
			answer = Math.max(answer, dist[i][goal] + dist[goal][i]);
		}
		System.out.println(answer);
	}

}


//int max = 0;
//int[] rt = new int[N+1];
//Arrays.fill(rt, Integer.MAX_VALUE);
//rt[goal] = 0;
//PriorityQueue<Edge> pq = new PriorityQueue<>();
//for(Edge e : edges[goal]) {
//	rt[e.to] = Math.min(rt[e.from] + e.w, rt[e.to]);
//	pq.add(e);
//}
//boolean[] vis = new boolean[N+1];
//vis[goal] = true;
//while(!pq.isEmpty()) {
//	Edge cur = pq.poll();
//	if(vis[cur.to]) continue;
//	vis[cur.to] = true;
//	for(Edge e : edges[cur.to]) {
//		rt[e.to] = Math.min(rt[e.from] + e.w, rt[e.to]);
//		pq.add(e);
//	}
//}
//
//for(int i = 1; i < N+1; i++) {
//	int[] dist = new int[N+1];
//	Arrays.fill(dist, Integer.MAX_VALUE);
//	dist[i] = 0;
//	pq = new PriorityQueue<>();
//	for(Edge e : edges[i]) {
//		dist[e.to] = Math.min(dist[e.from] + e.w, dist[e.to]);
//		pq.add(e);
//	}
//	vis = new boolean[N+1];
//	vis[i] = true;
//	while(!pq.isEmpty()) {
//		Edge cur = pq.poll();
//		if(vis[cur.to]) continue;
//		vis[cur.to] = true;
//		for(Edge e : edges[cur.to]) {
//			dist[e.to] = Math.min(dist[e.from] + e.w, dist[e.to]);
//			pq.add(e);
//		}
//	}
//	max = Math.max(dist[goal] + rt[i], max);
//}
//System.out.println(max);
