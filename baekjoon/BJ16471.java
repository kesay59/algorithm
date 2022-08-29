import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16471 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[2][N];
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				arr[i][n] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr[i]);
		}
		int cnt = 0;
		int idxA = N-1, idxB = N-1;
		for(; idxA >= 0; idxA--, idxB--) {
			while(idxA >= 0 && arr[0][idxA] >= arr[1][idxB]) {
				idxA--;
			}
			if(idxA < 0) break;
			cnt++;
		}
		if(cnt >= (N+1)/2) System.out.println("YES");
		else System.out.println("NO");
	}
}
