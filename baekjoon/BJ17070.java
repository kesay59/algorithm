import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ17070 {
	private static void move(char[][] map, int r, int c, int[][][] visArr) {
		if(visArr[r][c][0] > 0) {
			if(map[r][c+1] == '0') visArr[r][c+1][0] += visArr[r][c][0];
			if(map[r][c+1] == '0' && map[r+1][c+1] == '0' && map[r+1][c] == '0') visArr[r+1][c+1][1] += visArr[r][c][0];
		}
		if(visArr[r][c][1] > 0) {
			if(map[r][c+1] == '0') visArr[r][c+1][0] += visArr[r][c][1];
			if(map[r][c+1] == '0' && map[r+1][c+1] == '0' && map[r+1][c] == '0') visArr[r+1][c+1][1] += visArr[r][c][1];
			if(map[r+1][c] == '0') visArr[r+1][c][2] += visArr[r][c][1];
		}
		if(visArr[r][c][2] > 0) {
			if(map[r][c+1] == '0' && map[r+1][c+1] == '0' && map[r+1][c] == '0') visArr[r+1][c+1][1] += visArr[r][c][2];
			if(map[r+1][c] == '0') visArr[r+1][c][2] += visArr[r][c][2];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		char[][] map = new char[len + 1][];
		for(int i = 0; i < len; i++) {
			map[i] = br.readLine().replaceAll(" ", "").concat("0").toCharArray();
		}
		map[len] = new char[len + 1];
		Arrays.fill(map[len], '0');
		int[][][] visArr = new int[len+1][len+1][3];
		visArr[0][1][0] = 1;
		for(int k = 1; k < len; k++) {
			for(int i = 0; i < k; i++) {
				move(map, i, k, visArr);
			}
			for(int j = 0; j < k; j++) {
				move(map, k, j, visArr);
			}
			move(map, k, k, visArr);
		}
		System.out.println(visArr[len-1][len-1][0] + visArr[len-1][len-1][1] + visArr[len-1][len-1][2]);
	}
}
