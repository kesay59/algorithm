import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1029 {
	private static int N;
	private static int[][] cost;
	private static List<Integer>[][] next;
	private static int[][][] memo;
	private static int maxCnt = 0;
	
	private static void dp(int owner, int c, int mask, int cnt) {
		if(maxCnt < cnt) maxCnt = cnt;
		else if(memo[owner][c][mask] >= cnt) return;
		memo[owner][c][mask] = cnt;
		for(int n : next[owner][c]) {
			if((mask & (1<<n)) == 0) {
				dp(n, cost[owner][n], mask | (1<<n), cnt + 1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		String line;
		for(int i = 0; i < N; i++) {
			line = br.readLine();
			for(int j = 0; j < N; j++) {
				cost[i][j] = line.charAt(j) - '0';
			}
		}
		next = new ArrayList[N][10];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 10; j++) {
				next[i][j] = new ArrayList<Integer>();
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				for(int c = 0; c <= cost[i][j]; c++) {
					next[i][c].add(j);
				}
			}
		}
		memo = new int[N][10][(int) (Math.pow(2, N))];
		dp(0, 0, 1, 1);
		System.out.println(maxCnt);
	}
}
