import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int block = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int minHeight = 0;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				block += map[n][m];
				if(map[n][m] < minHeight) minHeight = map[n][m];
			}
		}
		int maxHeight = block / (N * M);
		int ansTime = Integer.MAX_VALUE;
		int ansHeight = minHeight;
		for(int height = minHeight; height <= maxHeight; height++) {
			int time = 0;
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					time += map[n][m] < height ? height - map[n][m] : (map[n][m] - height) * 2;
				}
			}
			if(ansTime < time) break;
			ansTime = time;
			ansHeight = height;
		}
		System.out.println(ansTime + " " + ansHeight);
	}
}
