import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2578 빙고
public class BJ2578 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[26][2]; 
		int[][] map = new int[5][5];
		StringTokenizer st;
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {				
				map[i][j] = Integer.parseInt(st.nextToken());
				arr[map[i][j]][0] = i;
				arr[map[i][j]][1] = j;
			}
		}
		
		int r, c, k, num, cnt = 0;
		boolean[][] vis = new boolean[5][5];
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				num = Integer.parseInt(st.nextToken());
				r = arr[num][0];
				c = arr[num][1];
				vis[r][c] = true;
				for(k = 0; k < 5; k++) 
					if(!vis[r][k]) break;
				if(k==5) {
					if(++cnt == 3) {
						System.out.println(i*5 + j + 1);
						System.exit(0);
					}
				}
				
				for(k = 0; k < 5; k++) 
					if(!vis[k][c]) break;
				if(k==5) {
					if(++cnt == 3) {
						System.out.println(i*5 + j + 1);
						System.exit(0);
					}
				}
				
				if(r == c){
					for(k = 0; k < 5; k++) 
						if(!vis[k][k]) break;
					if(k==5) {
						if(++cnt == 3) {
							System.out.println(i*5 + j + 1);
							System.exit(0);
						}
					}
				}
				
				if(r == 4 - c) {
					for(k = 0; k < 5; k++) 
						if(!vis[k][4-k]) break;
					if(k==5) {
						if(++cnt == 3) {
							System.out.println(i*5 + j + 1);
							System.exit(0);
						}
					}
				}
			}
		}
	}
}
