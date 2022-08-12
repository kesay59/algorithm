import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ14391 {
	private static int maxSum = 0;
	private static void sumNum(char[][] map, boolean[][] arr) {
		int sum = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = map[i].length - 1; j >= 0; j--) {
				if(arr[i][j]) {
					char[] line = new char[map[i].length];
					Arrays.fill(line, '0');
					int idx = line.length - 1;
					for(; j >= 0; j--, idx--) {
						if(arr[i][j]) line[idx] = map[i][j];
						else break;
					}
					sum += Integer.parseInt(new String(line));
				}
				
			}
		}
		for(int j = 0; j < map[0].length; j++) {
			for(int i = map.length - 1; i >= 0; i--) {
				if(!arr[i][j]) {
					char[] line = new char[map.length];
					Arrays.fill(line, '0');
					int idx = line.length - 1;
					for(; i >= 0; i--, idx--) {
						if(!arr[i][j]) line[idx] = map[i][j];
						else break;
					}
					sum += Integer.parseInt(new String(line));
				}
			}
		}
		maxSum = Math.max(maxSum, sum);
	}
	private static void test(char[][] map, boolean[][] arr, int r, int c) {
		if(c >= map[0].length) {
			r++;
			c = 0;
		}
		if(r >= map.length) {
			sumNum(map, arr);
			return;
		}
		arr[r][c] = false;
		test(map, arr, r, c+1);
		arr[r][c] = true;
		test(map, arr, r, c+1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		for(int r = 0; r < row; r++) {
			map[r] = br.readLine().toCharArray();
		}
		test(map, new boolean[row][col], 0, 0);
		System.out.println(maxSum);
	}
}
