import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ18352 {
	
	private static class Edge{
		int from, to;
		Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge>[] arr = new ArrayList[N + 1];
		for(int n = 1; n <= N; n++) {
			arr[n] = new ArrayList<Edge>();
		}
		
		int from, to;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			arr[from].add(new Edge(from, to));
		}
		
		int[] vis = new int[N+1];
		Arrays.fill(vis, Integer.MAX_VALUE);
		
		vis[X] = 0;
		Queue<Edge> que = new LinkedList<Edge>();
		for(Edge e : arr[X]) {
			que.offer(e);
		}
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			if(vis[cur.to] > vis[cur.from] + 1) {
				vis[cur.to] = vis[cur.from] + 1;
				for(Edge e : arr[cur.to]) {
					que.offer(e);
				}
			}
		}
		
		boolean flag = false;
		for(int n = 1; n <= N; n++) {
			if(vis[n] == K) {
				flag = true;
				System.out.println(n);
			}
		}
		if(!flag) System.out.println(-1);
	}
}
