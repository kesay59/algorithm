import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1647 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<int[]>[] houses = new ArrayList[N + 1];
		for(int i = 1; i < houses.length; i++) {
			houses[i] = new ArrayList<>();
		}
		int a, b, cost;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			houses[a].add(new int[] {b, cost});
			houses[b].add(new int[] {a, cost});
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		houses[1].forEach(r -> pq.offer(r));
		int sum = 0, maxCost = 0;
		int[] road;
		while(!pq.isEmpty()) {
			road = pq.poll();
			if(visited[road[0]]) continue;
			visited[road[0]] = true;
			houses[road[0]].forEach(r -> pq.offer(r));
			sum += road[1];
			if(maxCost < road[1]) maxCost = road[1];
		}
		System.out.println(sum - maxCost);
	}
}
