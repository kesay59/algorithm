import java.io.*;
import java.util.*;

public class BJ2583 {
	private static int R, C;
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, -1, 0, 1};
	private static int count(boolean[][] map, int r, int c) {
		map[r][c] = true;
		int cnt = 1;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc]) {
				continue;
			}
			cnt += count(map, nr, nc);
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[R][C];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int staC = Integer.parseInt(st.nextToken());
			int staR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			for(int r = staR; r < endR; r++) {
				for(int c = staC; c < endC; c++) {
					map[r][c] = true;
				}
			}
		}
		List<Integer> answer = new ArrayList<>();
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(!map[r][c]) {
					answer.add(count(map, r, c));
				}
			}
		}
		System.out.println(answer.size());
		answer.stream().sorted().forEach(ans -> System.out.print(ans + " "));
	}
}
