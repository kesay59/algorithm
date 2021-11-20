import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int nodeNum = Integer.parseInt(br.readLine());
		int busNum = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] busList = new ArrayList[nodeNum + 1];
		for(int i = 1; i <= nodeNum; i++) {
			busList[i] = new ArrayList<int[]>();
		}
		StringTokenizer st;
		for(int i = 0; i < busNum; i++) {
			st = new StringTokenizer(br.readLine());
			busList[Integer.parseInt(st.nextToken())].add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		boolean[] vis = new boolean[nodeNum + 1];
		long[] dist = new long[nodeNum + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		int cur;
		long cost;
		for(int c = 1; c <= nodeNum; c++) {
			cur = 0;
			for(int i = 1; i <= nodeNum; i++) {
				if(vis[i]) continue;
				cur = dist[cur] < dist[i] ? cur : i;
			}
			cost = dist[cur];
			for(int[] bus : busList[cur]) {
				dist[bus[0]] = Math.min(dist[bus[0]], cost + bus[1]);
			}
			vis[cur] = true;
		}
		System.out.println(dist[end]);
	}
}
