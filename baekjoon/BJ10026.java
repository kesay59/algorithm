import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10026 {
	
	private static int num;
	private static int[] cur = new int[2];
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, -1, 0, 1};
	
	private static boolean find(char[][] map, boolean[][] vis) {
		out : for(; cur[0] < num; cur[0]++) {
			for(; cur[1] < num; cur[1]++) {
				if(!vis[cur[0]][cur[1]]) {
					break out;
				}
			}
			cur[1] = 0;
		}
		if(cur[0] == num) return false;
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {cur[0], cur[1]});
		char sig = map[cur[0]][cur[1]];
		while(!que.isEmpty()) {
			int[] point = que.poll();
			if(vis[point[0]][point[1]] || map[point[0]][point[1]] != sig) continue;
			vis[point[0]][point[1]] = true;
			for(int d = 0; d < 4; d++) {
				if(point[0] + dr[d] >= 0 && point[0] + dr[d] < num && point[1] + dc[d] >= 0 && point[1] + dc[d] < num )
				que.offer(new int[] {point[0] + dr[d], point[1] + dc[d]});
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		char[][] map = new char[num][];
		for(int i = 0; i < num; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int colorCnt = 0;
		boolean[][] vis = new boolean[num][num];
		cur[0] = 0;
		cur[1] = 0;
		while(true) {			
			if(!find(map, vis)) break;
			colorCnt++;
		}
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R'; 
			}
		}
		int nonColorCnt = 0;
		vis = new boolean[num][num];
		cur[0] = 0;
		cur[1] = 0;
		while(true) {			
			if(!find(map, vis)) break;
			nonColorCnt++;
		}
		System.out.println(colorCnt + " " +  nonColorCnt);
 	}
}
