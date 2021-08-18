import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11048 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int len = row * col;
		int[] map = new int[len];
		int[] vis = new int[len];
		int[] lut = new int[row];
		for(int i = 1; i < row; i++)
			lut[i] = i * col;
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) 
				map[lut[i] + j] = Integer.parseInt(st.nextToken());
		}
		vis[0] = map[0];
		for(int i = 1; i < row; i++) 
			vis[lut[i]] = vis[lut[i-1]] + map[lut[i]];
		for(int j = 1; j < col; j++)
			vis[j] = vis[j-1] + map[j];
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				vis[lut[i] + j] = vis[lut[i-1] + j-1] + map[lut[i] + j];
				vis[lut[i] + j] = Math.max(vis[lut[i] + j], vis[lut[i] + j-1] + map[lut[i] + j]);
				vis[lut[i] + j] = Math.max(vis[lut[i] + j], vis[lut[i-1] + j] + map[lut[i] + j]);
			}
		}
		System.out.println(vis[len-1]);
	}

}
