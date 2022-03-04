import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] dist = new int[V+1][V+1];
		for(int i = 1; i <= V; i++) {
			Arrays.fill(dist[i], 4000001);
		}
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		for(int k = 1; k <= V; k++) {
			for(int i = 1; i <= V; i++) {
				for(int j = 1; j <= V; j++) {
					dist[i][j] = Math.min(dist[i][j], Math.min(dist[i][j], dist[i][k] + dist[k][j]));
				}
			}
		}
		int minCycle = Integer.MAX_VALUE;
		for(int i = 1; i <= V; i++) {
			for(int j = i+1; j <= V; j++) {
				if(dist[i][j] != 4000001 && dist[j][i] != 4000001) minCycle = Math.min(minCycle, dist[i][j] + dist[j][i]);
			}
		}
		System.out.println(minCycle == Integer.MAX_VALUE ? -1 : minCycle );
	}
}