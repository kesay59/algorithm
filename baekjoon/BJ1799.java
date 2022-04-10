import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class BJ1799 {
	private static int maxCnt = 0;
	private static int limDepth;
	private static int size;
	private static char[][] map;
	private static int[][] rightDiagonal;
	private static int rightLock;
	private static int[][] dp;
	private static void search(int depth, int cnt) {
		if(depth == limDepth) {
			if(cnt > maxCnt) maxCnt = cnt;
			return;
		}
		if(dp[depth][rightLock] >= cnt) return;
		dp[depth][rightLock] = cnt;
		int i = depth < size ? depth : size - 1;
		int j = depth < size ? 0 : depth + 1 - size;
		while(i >= 0 && j < size) {
			if(map[i][j] == '1') {
				if((rightLock & (1<<rightDiagonal[i][j])) == 0) {
					rightLock |= (1<<rightDiagonal[i][j]);
					search(depth+1, cnt+1);
					rightLock ^= (1<<rightDiagonal[i][j]);
				}
			}
			i--;
			j++;
		}
		search(depth+1, cnt);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		limDepth = size + size -1;
		map = new char[size][];
		for(int i = 0; i < size; i++) {
			map[i] = br.readLine().replaceAll(" ", "").toCharArray();
		}
		rightDiagonal = new int[size][size];
		for(int j = 0; j < size; j++) {
			rightDiagonal[0][size - 1 - j] = j;
		}
		for(int i = 1; i < size; i++) {
			for(int j = 0; j < size; j++) {
				rightDiagonal[i][j] = rightDiagonal[i-1][j] + 1;
			}
		}
		rightLock = 0;
		dp = new int[limDepth][1<<limDepth];
		for(int i = 0; i < limDepth; i++) {
			Arrays.fill(dp[i], -1);
		}
		search(0, 0);
		System.out.println(maxCnt);
	}
}
