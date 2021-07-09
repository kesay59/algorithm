import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2169{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] map = new int[row][col];
		int[][][] vis = new int[2][row][col]; //0은 왼쪽 진행, 1은 오른쪽 진행
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < row; i++){
			Arrays.fill(vis[0][i], Integer.MIN_VALUE);
			Arrays.fill(vis[1][i], Integer.MIN_VALUE);
		}
		
		vis[1][0][0] = map[0][0];
		for(int j = 1; j < col; j++) 
			vis[1][0][j] = vis[1][0][j - 1] + map[0][j];
		
		for(int i = 1; i < row; i++) {
			vis[1][i][0] = Math.max(vis[1][i-1][0], vis[0][i-1][0]) + map[i][0];
			for(int j = 1; j < col; j++) 
				vis[1][i][j] = Math.max(Math.max(vis[1][i-1][j], vis[0][i-1][j]), vis[1][i][j-1]) + map[i][j];
			vis[0][i][col-1] = Math.max(vis[0][i-1][col-1], vis[1][i-1][col-1]) + map[i][col-1];
			for(int j = col-2; j >= 0; j--) 
				vis[0][i][j] = Math.max(Math.max(vis[1][i-1][j], vis[0][i-1][j]), vis[0][i][j+1]) + map[i][j];
		}
		System.out.println(vis[1][row-1][col-1]);

	}

}
