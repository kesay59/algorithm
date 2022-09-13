import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ21316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[13][13];
		for(int i = 0; i < 13; i++) {
			Arrays.fill(arr[i], 100);
		}
		StringTokenizer st;
		int a, b;
		for(int i = 0; i < 12; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		for(int k = 1; k <= 12; k++) {
			for(int i = 1; i <= 12; i++) {
				for(int j = 1; j <= 12; j++) {
					if(arr[i][j] > arr[i][k] + arr[j][k]) arr[i][j] = arr[i][k] + arr[j][k];
				} 
			}
		}
		int cnt1, cnt3, cnt5;
		for(int i = 1; i <= 12; i++) {
			cnt1 = 0;
			cnt3 = 0;
			cnt5 = 0;
			for(int j = 1; j <= 12; j++) {
				if(arr[i][j] == 1) cnt1++;
				else if(arr[i][j] == 3) cnt3++;
				else if(arr[i][j] == 5) cnt5++;
			}
			if(cnt1 == 3 && cnt3 == 3 && cnt5 == 1) {
				System.out.println(i);
				return;
			}
		}
	}
}
