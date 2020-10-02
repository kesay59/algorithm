import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BJ 1080 행렬
public class BJ1080 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] ori = new char[row][];
		char[][] ans = new char[row][];
		for(int i = 0; i < row; i++)
			ori[i] = br.readLine().toCharArray();
		for(int i = 0; i < row; i++)
			ans[i] = br.readLine().toCharArray();
		int cnt = 0;
		int i = 0;
		for(; i < row - 2; i++) {
			for(int j = 0; j < col - 2; j++) {
				if(ori[i][j] != ans[i][j]) {
					cnt++;
					for(int m = 0; m < 3; m++) 
						for(int n = 0; n < 3; n++)
							ori[i + m][j + n] ^= 1;
				}
			}
			if(ori[i][col-2] != ans[i][col-2] || ori[i][col-1] != ans[i][col-1]) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		for(; i < row; i++) {
			for(int j = 0; j < col; j++)
				if(ori[i][j] != ans[i][j]) {
					System.out.println(-1);
					System.exit(0);
				}
		}
		System.out.println(cnt);

	}

}
