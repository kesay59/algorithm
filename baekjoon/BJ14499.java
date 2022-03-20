import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14499 {
	private static class Dice {
		int[] nextBottom = new int[] {0, 2, 3, 1, 4};
		
		int bottom = 0;
		int r, c;
		Dice(int r, int c) {
			this.r = r;
			this.c = c;
		}
		int[] numbers = new int[6];
		
		public void event(int dir) {
			int[] tmpNextBottom = new int[5];
			switch(dir) {
			case 1 :
				tmpNextBottom[1] = 5 - bottom;
				tmpNextBottom[2] = bottom;
				tmpNextBottom[3] = nextBottom[3];
				tmpNextBottom[4] = nextBottom[4];
				break;
			case 2 :
				tmpNextBottom[1] = bottom;
				tmpNextBottom[2] = 5 - bottom;
				tmpNextBottom[3] = nextBottom[3];
				tmpNextBottom[4] = nextBottom[4];
				break;
			case 3 :
				tmpNextBottom[1] = nextBottom[1];
				tmpNextBottom[2] = nextBottom[2];
				tmpNextBottom[3] = 5 - bottom;
				tmpNextBottom[4] = bottom;
				break;
			case 4 :
				tmpNextBottom[1] = nextBottom[1];
				tmpNextBottom[2] = nextBottom[2];
				tmpNextBottom[3] = bottom;
				tmpNextBottom[4] = 5 - bottom;
				break;
				
			}
			bottom = nextBottom[dir];
			nextBottom = tmpNextBottom;
		}
		public int getTopNumber() {
			return numbers[5 - bottom];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		Dice dice = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		int orderNum = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = new int[] {0, 0, 0, -1, 1};
		int[] dc = new int[] {0, 1, -1, 0, 0};
		StringBuilder answer = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int o = 0; o < orderNum; o++) {
			int order = Integer.parseInt(st.nextToken());
			int nextR = dice.r + dr[order];
			int nextC = dice.c + dc[order];
			if(nextR < 0 || nextR >= row || nextC < 0 || nextC >= col) continue;
			dice.r = nextR;
			dice.c = nextC;
			dice.event(order);
			if(map[dice.r][dice.c] == 0) {
				map[dice.r][dice.c] = dice.numbers[dice.bottom];
			} else {
				dice.numbers[dice.bottom] = map[dice.r][dice.c];
				map[dice.r][dice.c] = 0;
			}
			answer.append(dice.getTopNumber()).append('\n');
		}
		System.out.println(answer.toString());
	}
}
