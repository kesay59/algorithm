

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2615 오목
public class BJ2615 {
	private static char arr[][];

	private static int[] dr = new int[] { 1, 0, -1, -1 };
	private static int[] dc = new int[] { -1, -1, -1, 0 };

	private static void search(int r, int c, int dir, int dp) {
		if (dp == 5) {
			if (arr[r + dr[dir]][c + dc[dir]] == arr[r][c])
				return;
			else {
				System.out.println(arr[r][c] + "\n" + r + " " + c);
				System.exit(0);
			}
		}
		if (arr[r + dr[dir]][c + dc[dir]] == arr[r][c])
			search(r + dr[dir], c + dc[dir], dir, dp + 1);
		else
			return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[21][];
		arr[0] = new char[21];
		arr[20] = new char[21];
		for (int i = 1; i < 20; i++)
			arr[i] = (0 + br.readLine() + 0).replace(" ", "").toCharArray();
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (arr[i][j] != 48) {
					for (int k = 0; k < 4; k++) {
						if (arr[i - dr[k]][j - dc[k]] == arr[i][j])
							continue;
						search(i, j, k, 1);
					}
				}
			}
		}
		System.out.println(0);
	}
}
