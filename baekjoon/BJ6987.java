import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6987 {
	private static int[][] input;
	private static boolean testResult(int[][] table, int r, int c, int win, int draw, int lose) {
		if(win < 0 || draw < 0 || lose < 0) return false;
		if(c == 6) {
			if(win != 0 || draw != 0 || lose != 0) return false;
			if(r < 5) {
				int winCnt = 0, drawCnt = 0, loseCnt = 0;
				for(int idx = 0; idx < r + 1; idx++) {
					if(table[r+1][idx] == 0) winCnt++;
					else if(table[r+1][idx] == 1) drawCnt++;
					else loseCnt++;
				}
				return testResult(table, r + 1, r + 1, input[r+1][0] - winCnt, input[r+1][1] - drawCnt, input[r+1][2] - loseCnt);
			} else {
				System.out.print("1 ");
				return true;
			}
		} else {
			if(r == c) {
				return testResult(table, r, c+1, win, draw, lose);
			} else {				
				if(win > 0) {
					table[r][c] = 0;
					table[c][r] = 2;
					if(testResult(table, r, c+1, win-1, draw, lose)) return true;
				}
				if(draw > 0) {
					table[r][c] = 1;
					table[c][r] = 1;
					if(testResult(table, r, c+1, win, draw-1, lose)) return true;
				}
				if(lose > 0) {
					table[r][c] = 2;
					table[c][r] = 0;
					if(testResult(table, r, c+1, win, draw, lose-1)) return true;
				}
				return false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input = new int[6][3];
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(!testResult(new int[6][6], 0, 0, input[0][0], input[0][1], input[0][2])) System.out.print("0 ");
		}
	}
}
