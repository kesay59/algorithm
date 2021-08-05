import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4386 {
	private static class Edge implements Comparable<Edge>{
		int to;
		double cost;
		
		Edge(int to, double cost){
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.cost - o.cost < 0) return -1;
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		double[][] arr = new double[num][];
		
		StringTokenizer st;
		for(int n = 0; n < num; n++) {
			st = new StringTokenizer(br.readLine());
			arr[n] = new double[] {Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())};
		}
		
		ArrayList<Edge>[] edges = new ArrayList[num];
		for(int n = 0; n < num; n++) {
			edges[n] = new ArrayList<Edge>();
			for(int k = 0; k < num; k++) {
				if(n==k) continue;
				edges[n].add(new Edge(k, Math.sqrt(Math.pow(arr[n][0] - arr[k][0], 2) + Math.pow(arr[n][1] - arr[k][1], 2))));
			}
		}
		
		boolean[] vis = new boolean[num];
		vis[0] = true;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for(Edge e : edges[0])
			pq.add(e);
		double sum = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(vis[cur.to]) continue;
			vis[cur.to] = true;
			sum += cur.cost;
			for(Edge e : edges[cur.to])
				pq.add(e);
		}
		System.out.println(sum);
	}
}
