import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BJ 1520 내리막 길
public class BJ1520 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[] dr = new int[] {-1, 0, 0, 1};
		int[] dc = new int[] {0, -1, 1, 0};
		int[][] map = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[][] rt = new int[row][col];
		for(int i = 0; i < row; i++)
			Arrays.fill(rt[i], -1);
		rt[0][0] = 1;
		boolean[][] ck = new boolean[row][col];
		ck[0][0] = true;
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i = 0; i < row; i++) {
				nx : for(int j = 0; j < col; j++) {
					if(!ck[i][j]) {
						flag = true;
						int sum = 0;
						for(int k = 0; k < 4; k++) {
							int r = i + dr[k];
							int c = j + dc[k];
							if(r < 0 || r >= row || c < 0 || c >= col) continue;
							if(map[r][c] > map[i][j]) {
								if(rt[r][c] == -1) continue nx;
								sum += rt[r][c];
							}
						}
						rt[i][j] = sum;
						ck[i][j] = true;
					}
				}
			}
		}
		System.out.println(rt[row-1][col-1]);

	}

}
