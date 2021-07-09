import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2096 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pre = 0;
		int cur = 1;
		int len = Integer.parseInt(br.readLine());
		int[][] mint = new int[2][3];
		int[][] maxt = new int[2][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 3; i++) 
			mint[0][i] = maxt[0][i] = Integer.parseInt(st.nextToken());
		for(int n = 1; n < len; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			mint[cur][0] = Math.min(mint[pre][0], mint[pre][1]) + x;
			mint[cur][1] = Math.min(mint[pre][0], mint[pre][1]);
			mint[cur][1] = Math.min(mint[cur][1], mint[pre][2]) + y;
			mint[cur][2] = Math.min(mint[pre][1], mint[pre][2]) + z;
			maxt[cur][0] = Math.max(maxt[pre][0], maxt[pre][1]) + x;
			maxt[cur][1] = Math.max(maxt[pre][0], maxt[pre][1]);
			maxt[cur][1] = Math.max(maxt[cur][1], maxt[pre][2]) + y;
			maxt[cur][2] = Math.max(maxt[pre][1], maxt[pre][2]) + z;
			pre ^= 1;
			cur ^= 1;
		}
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < 3; i++) {
			min = Math.min(min, mint[pre][i]);
			max = Math.max(max, maxt[pre][i]);
		}
		System.out.println(max + " " + min);
	}

}
