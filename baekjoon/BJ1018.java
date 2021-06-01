import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		for(int i = 0 ; i < row; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int check[][][] = new int[2][row][col - 7];
		for(int i = 0; i < row; i++) {
			char alp = i % 2 == 0? 'B' : 'W';
			for(int j = 0; j < 8; j++) {
				if(map[i][j] != alp) check[0][i][0]++;
				else check[1][i][0]++;
				
				if(alp == 'B') alp = 'W';
				else alp = 'B';
			}
			
			for(int j = 8; j < col; j++) {
				check[0][i][j-7] = check[0][i][j-8];
				check[1][i][j-7] = check[1][i][j-8];
				
				if(map[i][j] != alp) check[0][i][j - 7]++;  
				else check[1][i][j - 7]++;
				
				if(map[i][j-8] != alp) check[0][i][j - 7]--; 
				else check[1][i][j - 7]--;
				
				if(alp == 'B') alp = 'W';
				else alp = 'B';
				
			}
		}
		
		int ans[][][] = new int[2][row - 7][col - 7];
		for(int j = 0; j < col - 7; j++) {
			for(int i = 0; i < 8; i++) {
				ans[0][0][j] += check[0][i][j];
				ans[1][0][j] += check[1][i][j];
			}
			
			for(int i = 8; i < row; i++) {
				ans[0][i - 7][j] = ans[0][i - 8][j] - check[0][i - 8][j] + check[0][i][j];
				ans[1][i - 7][j] = ans[1][i - 8][j] - check[1][i - 8][j] + check[1][i][j];
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int a = 0; a < 2; a++) {
			for(int i = 0; i < row - 7; i++) {
				for(int j = 0; j < col - 7; j++) {
					answer = Math.min(answer, ans[a][i][j]);
				}
			}
		}
		
		System.out.println(answer);
	}
}
