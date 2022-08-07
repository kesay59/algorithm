import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2098 {
	private static int num;
	private static int[][] edges;
	private static int[][] costs;
	private static List<Integer>[] edgeList;
	private static int minCost = Integer.MAX_VALUE;
	
	private static void move(int start, int cur, int cnt, int mask, int cost) {
		if(cost >= costs[cur][mask]) return;
		costs[cur][mask] = cost;
		if(start == cur) {
			if(cnt != 0) {				
				if(cnt == num) {
					minCost = Math.min(minCost, cost + edges[cur][start]);
				}
				return; 
			}
		} else {
			mask |= (1 << cur);
		}
		
		for(int n : edgeList[cur]) {
			if(edges[cur][n] == 0 || cur == n || (mask & (1<<n)) != 0) continue;
			move(start, n, cnt+1, mask, cost + edges[cur][n]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		edges = new int[num][num];
		StringTokenizer st;
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < num; j++) {
				edges[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		edgeList = new ArrayList[num];
		int[][] arr = new int[num][2];
		for(int n = 0; n < num; n++) {
			for(int k = 0; k < num; k++) {				
				arr[k][0] = k;
				arr[k][1] = edges[n][k];
			}
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
			edgeList[n] = new ArrayList<Integer>();
			for(int i = 0; i < num; i++) {
				if(arr[i][1] == 0) continue;
				edgeList[n].add(arr[i][0]);
			}
			edgeList[n].add(n);
		}
		
		costs = new int[num][(int) Math.pow(2, num)];
		for(int n = 0; n < num; n++) {		
			Arrays.fill(costs[n], Integer.MAX_VALUE);
		}
		for(int n = 0; n < num; n++) {
			move(n, n, 0, 0, 0);			
		}
		System.out.println(minCost);
	}
}
