import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()) - 1;
		int[] dist = new int[num];
		int[] cost = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int d = 0; d < num; d++) {
			dist[d] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long minCost = Integer.parseInt(st.nextToken());
		long sum = minCost * dist[0];
		for(int c = 1; c < num; c++) {
			cost[c] = Integer.parseInt(st.nextToken());
			if(cost[c] < minCost) minCost = cost[c];
			sum += dist[c] * minCost;
		}
		System.out.println(sum);

	}

}
