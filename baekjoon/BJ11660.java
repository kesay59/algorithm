import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] table = new int[N+1][N+1];
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				table[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] arr = new int[N+1][N+1];
		for(int r = 1; r <= N; r++) {
			int sum = 0;
			for(int c = 1; c <= N; c++) {
				sum += table[r][c];
				arr[r][c] = sum + arr[r-1][c];
			}
		}
		StringBuilder stb = new StringBuilder();
		int staR, staC, endR, endC;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			staR = Integer.parseInt(st.nextToken());
			staC = Integer.parseInt(st.nextToken());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			stb.append(arr[endR][endC] - arr[staR-1][endC] - arr[endR][staC-1] + arr[staR-1][staC-1]).append('\n');
		}
		System.out.println(stb.toString());
	}
}
