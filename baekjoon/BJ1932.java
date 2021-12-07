import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[num][num];
		arr[0][0] = Integer.parseInt(br.readLine());
		for(int i = 1; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = arr[i-1][0] + Integer.parseInt(st.nextToken());
			for(int j = 1; j < i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + Math.max(arr[i-1][j-1], arr[i-1][j]);
			}
			arr[i][i] = arr[i-1][i-1] + Integer.parseInt(st.nextToken());
		}
		int maxRes = 0;
		for(int i = 0; i < num; i++) {
			maxRes = Math.max(maxRes, arr[num-1][i]);
		}
		System.out.println(maxRes);
	}
}
