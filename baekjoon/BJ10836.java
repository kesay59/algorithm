import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10836 {
	private static int M;
	private static int[][] map;
	private static void grow(int[] cnt) {
		int flag = 0;
		for(int i = M - 1; i >= 0; i--) {
			while(cnt[flag] == 0) flag++;
			map[i][0] += flag;
			cnt[flag]--;
		}
		for(int j = 1; j < M; j++) {
			while(cnt[flag] == 0) flag++;
			map[0][j] += flag;
			cnt[flag]--;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][M];
		int N = Integer.parseInt(st.nextToken());
		int[] cnt = new int[3];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				cnt[i] = Integer.parseInt(st.nextToken());
			}
			grow(cnt);
		}
		StringBuilder stb = new StringBuilder();
		for(int j = 1; j < M; j++) {
			stb.append(' ').append(map[0][j] + 1);
		}
		stb.append('\n');
		StringBuilder answer = new StringBuilder();
		for(int i = 0; i < M; i++) {
			answer.append(map[i][0] + 1).append(stb.toString());
		}
		System.out.println(answer);
	}
}
