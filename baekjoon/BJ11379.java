import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11379 {
//	private static long[] arr = new long[29];
//	private static boolean[][] vis = new boolean[30][30];
//	private static int[] dr = new int[] {-1, 0, 1, 0};
//	private static int[] dc = new int[] {0, -1, 0, 1};
//	private static void countRoute(int r, int c, int cnt) {
//		arr[cnt]++;
//		if(cnt < 28) {
//			vis[r][c] = true;
//			int nr, nc;
//			for(int d = 0; d < 4; d++) {
//				nr = r + dr[d];
//				nc = c + dc[d];
//				if(nr < 0 || nc < 0 || vis[nr][nc]) continue;
//				countRoute(nr, nc, cnt+1);
//			}
//			vis[r][c] = false;
//		}
//	}
	public static void main(String[] args) throws IOException {
//		arr[0] = 0;
//		vis[0][0] = true;
//		countRoute(0, 1, 1);
//		System.out.println(Arrays.toString(arr));
		long[] arr = new long[] {0, 1, 2, 5, 12, 30, 73, 183, 456, 1151, 2900, 7361, 18684, 47652, 121584, 311259, 797311, 2047384, 5260692, 13542718, 34884239, 89991344, 232282110, 600281932, 1552096361, 4017128206L, 10401997092L, 26957667445L, 69892976538L};
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		long sum = 0;
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		for(int k = a; k <= b; k++) {
			sum += arr[k];
		}
		System.out.println(sum);
	}
}
