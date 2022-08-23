import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1976 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[][] table = new boolean[N+1][N+1];
		for(int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				table[r][c] = st.nextToken().charAt(0) == '1';
			}
		}
		for(int k = 1; k <= N; k++) {
			for(int r = 1; r <= N; r++) {
				for(int c = 1; c <= N; c++) {
					if(!table[r][c]) table[r][c] = table[r][k] && table[k][c];
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean flag = true;
		int prev = Integer.parseInt(st.nextToken()), cur = 0;
		for(int m = 1; m < M; m++) {
			cur = Integer.parseInt(st.nextToken());
			if(prev != cur && !table[prev][cur]) {
				flag = false;
				break;
			}
			prev = cur;
		}
		System.out.println(flag ? "YES" : "NO");
	}
}
