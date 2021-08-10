import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14890 {
	
	private static boolean[] vis;
	private static int lim, len;
	private static char[][] map;
	
	
	private static boolean rowup(int row, int idx) {
		for(int s = 0; s < lim; s++) {
			int cur = idx - s;
			if(cur < 0 || vis[cur] || map[row][cur] != map[row][idx + 1] - 1) return false;
			vis[cur] = true;
		}
		return true;
	}
	
	private static boolean rowdown(int row, int idx) {
		for(int s = 0; s < lim; s++) {
			int cur = idx + s;
			if(cur >= len || vis[cur] || map[row][cur] != map[row][idx - 1] - 1) return false;
			vis[cur] = true;
		}
		return true;
	}
	
	private static boolean colup(int idx, int col) {
		for(int s = 0; s < lim; s++) {
			int cur = idx - s;
			if(cur < 0 || vis[cur] || map[cur][col] != map[idx + 1][col] - 1) return false;
			vis[cur] = true;
		}
		return true;
	}
	
	private static boolean coldown(int idx, int col) {
		for(int s = 0; s < lim; s++) {
			int cur = idx + s;
			if(cur >= len || vis[cur] || map[cur][col] != map[idx - 1][col] - 1) return false;
			vis[cur] = true;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			lim = Integer.parseInt(st.nextToken());
			
			map = new char[len][];
			for(int l = 0; l < len; l++) 
				map[l] = br.readLine().replace(" ", "").toCharArray();
			
			int cnt = 0;
			for(int i = 0; i < len; i++) {
				int pre = map[i][0];
				vis = new boolean[len];
				for(int j = 1; j < len; j++) {
					if(map[i][j] > pre) {
						if(!rowup(i, j-1)) break;
					} else if(map[i][j] < pre) {
						if(!rowdown(i, j)) break;
					}
					pre = map[i][j];
					if(j==len-1) cnt++;
				}
			}
			
			for(int j = 0; j < len; j++) {
				int pre = map[0][j];
				vis = new boolean[len];
				for(int i = 1; i < len; i++) {
					if(map[i][j] > pre) {
						if(!colup(i-1, j)) break;
					} else if(map[i][j] < pre) {
						if(!coldown(i, j)) break;
					}
					pre = map[i][j];
					if(i==len-1) cnt++;
				}
			}
			
			System.out.println(cnt);
		
	}
}
