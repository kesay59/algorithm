import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ2665 {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int leng = Integer.parseInt(br.readLine());
		char[][] map = new char[leng][];
		int[][] vis = new int[leng][leng];
		for(int i = 0; i < leng; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(vis[i], Integer.MAX_VALUE);
		}
		int[] dr = new int[] {-1, 0, 1, 0};
		int[] dc = new int[] {0, -1, 0, 1};
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		pq.offer(new int[] {0, 0, 0});
		vis[0][0] = 0;
		int r, c, cnt;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[0] == leng - 1 && cur[1] == leng - 1) break;
			for(int d = 0; d < 4; d++) {
				r = cur[0] + dr[d];
				c = cur[1] + dc[d];
				if(r < 0 || r >= leng || c < 0 || c >= leng) continue;
				cnt = cur[2] + (map[r][c] == '1' ? 0 : 1);
				if(vis[r][c] > cnt) {
					vis[r][c] = cnt;
					pq.add(new int[] {r, c, cnt});
				}
			}
		}
		System.out.println(vis[leng-1][leng-1]);
	}
}
