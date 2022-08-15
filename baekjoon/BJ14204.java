import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14204 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] table = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				table[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int n = 0; n < N; n++) {
			int[] arr = table[n].clone();
			Arrays.sort(arr);
			for(int m = 1; m < M; m++) {
				if(arr[m-1] + 1 != arr[m]) {
					System.out.println(0);
					return;
				}
			}
		}
		
		for(int m = 0; m < M; m++) {
			int[] arr = new int[N];
			for(int n = 0; n < N; n++) {
				arr[n] = table[n][m];
			}
			Arrays.sort(arr);
			for(int n = 1; n < N; n++) {
				if(arr[n-1] + M != arr[n]) {
					System.out.println(0);
					return;
				}
			}
		}
		
		System.out.println(1);
	}
}
// 순서를 아무리 바꿔도 자신이 포함된 열, 행과 항상 같이 움직임
// 행은 정렬했을 때 1씩 커지는 등차수열
// 열은 정렬했을 때 r씩 커지는 등차수열
