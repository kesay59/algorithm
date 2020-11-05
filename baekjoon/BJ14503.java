import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503 {

	private static int row, col, cnt, r, c, dir;
	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	private static char[][] map;
	
	
	private static void move() {
		for(int k = 0; k < 4; k++) {
			dir = (dir+3)%4;
			int tr = r + dr[dir];
			int tc = c + dc[dir];
			if(map[tr][tc] > 48) continue;
			cnt++;
			map[tr][tc] = 50;
			r = tr;
			c = tc;
			return;
		}
		r -= dr[dir];
		c -= dc[dir];
		if(map[r][c] == 49) {
			System.out.println(cnt + 1);
			System.exit(0);			
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		map = new char[row][];
		for(int i = 0; i < row; i++) 
			map[i] = br.readLine().replace(" ", "").toCharArray();
		cnt = 0;
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		while(true) {
			map[r][c] = 50;
			move();
		}
	}

}
