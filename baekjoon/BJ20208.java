import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ20208 {
	private static int N;
	private static int M;
	private static int H;
	private static int[][] dist;
	private static int[] memo;
	private static int maxCnt = 0;
	
	private static void sel(int idx, int milk, int cnt, int health) {
		if(health < memo[milk]) return;
		memo[milk] = health;
		
		if(idx != 0) health += H;
		if(dist[0][idx] <= health && cnt > maxCnt) maxCnt = cnt;
		
		for(int i = 1; i < dist.length; i++) {
			if(dist[idx][i] > health || (milk & (1<<(i-1))) != 0) continue;
			sel(i, milk | (1<<(i-1)), cnt + 1, health - dist[idx][i]);			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int cur;
		List<int[]> pointList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				cur = Integer.parseInt(st.nextToken());
				if(cur == 2) pointList.add(new int[] {i, j});
				else if(cur == 1) pointList.add(0, new int[] {i, j});
			}
		}
		dist = new int[pointList.size()][pointList.size()];
		for(int i = 0; i < pointList.size(); i++) {
			for(int j = i + 1; j < pointList.size(); j++) {
				dist[i][j] = dist[j][i] = Math.abs(pointList.get(i)[0] - pointList.get(j)[0]) +  Math.abs(pointList.get(i)[1] - pointList.get(j)[1]);
			}
		}
		memo = new int[(int) Math.pow(2, pointList.size())];
		sel(0, 0, 0, M);
		System.out.println(maxCnt);
	}
}
