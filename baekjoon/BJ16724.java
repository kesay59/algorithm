import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16724 {
	private static int row, col;
	private static char[][] map;
	private static boolean[][] vis;
	private static boolean[][] safeZone;
	private static int safeZoneCnt = 0;
	private static void move(int r, int c) {
		vis[r][c] = true;
		int nextR, nextC;
		if(map[r][c] == 'U') {
			nextR = r - 1;
			nextC = c;
		} else if(map[r][c] == 'L') {
			nextR = r;
			nextC = c - 1;
		} else if(map[r][c] == 'R') {
			nextR = r;
			nextC = c + 1;
		} else {
			nextR = r + 1;
			nextC = c;
		}
		if(nextR < 0 || nextR >= row || nextC < 0 || nextC >= col || vis[nextR][nextC]) {
			if(!safeZone[nextR][nextC]) {				
				safeZone[r][c] = true;
				safeZoneCnt++;
			}
		} else {
			move(nextR, nextC);
		}
		safeZone[r][c] = true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][];
		for(int r = 0; r < row; r++) {
			map[r] = br.readLine().toCharArray();
		}
		vis = new boolean[row][col];
		safeZone = new boolean[row][col];
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(!vis[r][c]) move(r, c);
			}
		}
		System.out.println(safeZoneCnt);
	}
}
