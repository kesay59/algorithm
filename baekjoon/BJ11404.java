import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] dist = new int[num + 1][num + 1];
		for (int i = 1; i <= num; i++) {
			Arrays.fill(dist[i],  10000001);
		}
		int E = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int sta, end, cost;
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			sta = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			dist[sta][end] = Math.min(dist[sta][end], cost);
		}
		for(int k = 1; k <= num; k++) {
			for(int i = 1; i <= num; i++) {
				for(int j = 1; j <= num; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		StringBuilder stb = new StringBuilder();
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				if(i == j || dist[i][j] > 10000000) stb.append(0);
				else stb.append(dist[i][j]);
				stb.append(' ');
			}
			stb.append('\n');
		}
		System.out.println(stb);
	}
}
