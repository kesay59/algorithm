import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//swExpertAcademy 3282 0/1 knapsack
public class EA3282 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcN = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= tcN; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int cpct = Integer.parseInt(st.nextToken());
			int[][] memo = new int[2][cpct + 1];
			int pre = 0;
			int cur = 1;
			for(int i = 1; i < len + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int siz = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				for(int j = 1; j < cpct + 1; j++) 
					if(siz <= j) memo[cur][j] = Math.max(memo[pre][j], memo[pre][j-siz] + val);
					else memo[cur][j] = memo[pre][j];
				cur ^= 1;
				pre ^= 1;
			}
			System.out.println("#" + tc + " " + memo[pre][cpct]);
		}
	}
}