import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ16946 {
	private static int N, M;
	private static int[] dr = new int[] {-1, 1, 0, 0};
	private static int[] dc = new int[] {0, 0, -1, 1};
	private static char[][] map;
	private static boolean[][] vis;
	private static int[][] countArr;
	private static int[][] answer;
	private static int sum;
	private static List<Integer> sumList = new ArrayList<>();
	private static int idx = 1;
	
	private static void save(int r, int c) {
		countArr[r][c] = idx;
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '1' || countArr[nr][nc] != 0) continue;
			save(nr, nc);
		}
	}
	private static void count(int r, int c) {
		if(vis[r][c]) return;
		vis[r][c] = true;
		sum++;
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '1') continue;
			count(nr, nc);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		for(int n = 0; n < N; n++) {
			map[n] = br.readLine().toCharArray();
		}
		
		answer = new int[N][M];
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] == '1') answer[n][m] = 1;
			}
		}
		
		countArr = new int[N][M];
		vis = new boolean[N][M];
		sumList.add(0);
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] == '0' && !vis[n][m]) {
					sum = 0;
					count(n, m);
					sumList.add(sum);
					save(n, m);
					idx++;
				}
			}
		}
		
		int nn, nm;
		StringBuilder stb = new StringBuilder();
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] == '1') {
					List<Integer> prevIdx = new ArrayList<>();
					for(int d = 0; d < 4; d++) {
						nn = n + dr[d]; 
						nm = m + dc[d];
						if(nn < 0 || nn >= N || nm < 0 || nm >= M || map[nn][nm] == '1' || prevIdx.contains(countArr[nn][nm])) continue;
						prevIdx.add(countArr[nn][nm]);
						answer[n][m] += sumList.get(countArr[nn][nm]);
					}
				}
				stb.append(answer[n][m] % 10);
			}
			stb.append('\n');
		}
		System.out.println(stb.toString());
	}
}
// 0이면 DFS로 탐색하면서 idx를 기록 (idx는 1부터 시작)
// 인접한 0들의 합계를 idx를 기준으로 저장
// 최종 계산 시 idx를 보고 중복은 제외하면서 인접 4방향의 합을 구함
