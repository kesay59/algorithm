import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	private static int[][] map;
	private static Queue<Point> que = new LinkedList<>();
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		Point tmp;
		
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) que.add(new Point(i, j));
			}
		}
		
		int cnt = 0;
		while(!que.isEmpty()) {
			que.add(new Point(-100, 0));
			while(true) {
				tmp = que.poll();
				if(tmp.x == -100) break;
				for(int k = 0; k < 4; k++) {
					if(tmp.x + dr[k] < 0 || tmp.x + dr[k] >= h || tmp.y + dc[k] < 0 || tmp.y + dc[k] >= w) continue;
					if(map[tmp.x + dr[k]][tmp.y + dc[k]] == 0) {
						map[tmp.x + dr[k]][tmp.y + dc[k]] = 1;
						que.add(new Point(tmp.x + dr[k], tmp.y + dc[k]));
					}
				}
			}
			cnt++;
		}
		
		out : for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++)
				if(map[i][j] == 0) {
					cnt = 0;
					break out;
				}
		}
		
		System.out.println(cnt - 1);
		
	}

}