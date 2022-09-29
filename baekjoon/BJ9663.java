import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 9663 n-queen
public class BJ9663 {

	static int len;
	static int[][] vis;
	static int cnt;
	
	static void find(int r, int c){
		if(vis[r][c] > 0) return;
		if(r == len - 1) {
			cnt++;
			return;
		}
		for(int i = 1; i < len - r; i++) {
			vis[r + i][c]++;
			if(c + i < len) vis[r + i][c + i]++;
			if(c - i > -1) vis[r + i][c - i]++;
		}
		for(int i = 0; i < len; i++)
			find(r + 1, i);
		for(int i = 1; i < len - r; i++) {
			vis[r + i][c]--;
			if(c + i < len) vis[r + i][c + i]--;
			if(c - i > -1) vis[r + i][c - i]--;
		}
	}
	
	public static void main(String[] args) throws IOException {
		len = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		vis = new int[len][len];
		for(int i = 0; i < len; i++)
			find(0, i);
		System.out.println(cnt);
	}

}
