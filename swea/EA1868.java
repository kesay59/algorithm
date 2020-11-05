import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//SWEA 1868 파핑파핑 지뢰찾기
public class EA1868 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcN = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= tcN; tc++) {
			int len = Integer.parseInt(br.readLine());
			int[][] map = new int[len][len];
			int[] dr = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] dc = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
			for(int i = 0; i < len; i++) {
				char[] tmp = br.readLine().toCharArray();
				for(int j = 0; j < len; j++) {
					if(tmp[j] == '*') {
						map[i][j] = 10;
						for(int k = 0; k < 8; k++) {
							int r = i + dr[k];
							int c = j + dc[k];
							if(r < 0 || c < 0 || r >= len || c >= len) continue;
							if(map[r][c] != 10) map[r][c]++;
						}
					}
				}
			}
			Queue<int[]> que = new LinkedList<>();
			int answer = 0;
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					if(map[i][j] == 0) {
						answer++;
						que.add(new int[] {i, j});
						map[i][j] = 10;
						while(!que.isEmpty()) {
							int[] cur = que.poll();
							for(int k = 0; k < 8; k++) {
								int r = cur[0] + dr[k];
								int c = cur[1] + dc[k];
								if(r < 0 || c < 0 || r >= len || c >= len || map[r][c] == 10) continue;
								if(map[r][c] == 0) que.add(new int[] {r, c});
								map[r][c] = 10;
							}
						}
					}
				}
			}
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					if(map[i][j] != 10) answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		

	}

}
