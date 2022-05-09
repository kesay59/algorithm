import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int[][][] box = new int[height][row][col];
		int cnt = 0;
		Queue<int[]>[] que = new Queue[2];
		que[0] = new LinkedList<int[]>();
		que[1] = new LinkedList<int[]>();
		for(int h = 0; h < height; h++) {
			for(int r = 0; r < row; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < col; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());
					if(box[h][r][c] == 0) cnt++;
					else if(box[h][r][c] == 1) que[0].add(new int[] {h, r, c});
				}
			}
		}
		if(cnt == 0) {
			System.out.println(0);
			return;
		}
		
		int[] dh = new int[] {-1, 1, 0, 0, 0, 0};
		int[] dr = new int[] {0, 0, -1, 0, 1, 0};
		int[] dc = new int[] {0, 0, 0, -1, 0, 1};
		int date = 0;
		byte cur = 0;
		while(!que[0].isEmpty() || !que[1].isEmpty()) {
			while(!que[cur].isEmpty()) {
				int[] point = que[cur].poll();
				int nh, nr, nc;
				for(int d = 0; d < 6; d++) {
					nh = point[0] + dh[d];
					nr = point[1] + dr[d];
					nc = point[2] + dc[d];
					if(nh >= 0 && nh < height && nr >= 0 && nr < row && nc >= 0 && nc < col && box[nh][nr][nc] == 0) {
						box[nh][nr][nc] = 1;
						cnt--;
						que[cur^1].offer(new int[] {nh, nr, nc});
					}
				}
			}
			date++;
			if(cnt == 0) {
				System.out.println(date);
				return;
			}
			cur ^= 1;
		}
		System.out.println(-1);
	}
}
