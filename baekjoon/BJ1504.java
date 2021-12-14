import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vNum = Integer.parseInt(st.nextToken());
		int eNum = Integer.parseInt(st.nextToken());
		ArrayList<int[]>[] edgeList = new ArrayList[vNum+1];
		for(int i = 1; i <= vNum; i++) {
			edgeList[i] = new ArrayList<int[]>();
		}
		int a, b, cost;
		for(int j = 0; j < eNum; j++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			edgeList[a].add(new int[] {b, cost});
			edgeList[b].add(new int[] {a, cost});			
		}
		int mid1, mid2;
		st = new StringTokenizer(br.readLine());
		mid1 = Integer.parseInt(st.nextToken());
		mid2 = Integer.parseInt(st.nextToken());
		int[][] vis = new int[vNum+1][4];
		for(int i = 1; i <= vNum; i++) {
			Arrays.fill(vis[i], Integer.MAX_VALUE);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int[] movement = new int[] {1, 0, 0};
		if(movement[0] == mid1) movement[1] ^= 2;
		if(movement[0] == mid2) movement[1] ^= 1;
		pq.offer(movement);
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(vis[cur[0]][cur[1]] <= cur[2]) continue;
			vis[cur[0]][cur[1]] = cur[2];
			for(int[] edge : edgeList[cur[0]]) {
				movement = new int[] {edge[0], cur[1], cur[2] + edge[1]};
				if(movement[0] == mid1 && movement[1] < 2) movement[1] ^= 2;
				if(movement[0] == mid2 && movement[1] % 2 == 0) movement[1] ^= 1;
				pq.offer(movement);
			}
		}
		System.out.println(vis[vNum][3] == Integer.MAX_VALUE ? -1 : vis[vNum][3]);
	}
}
