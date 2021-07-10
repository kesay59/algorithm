import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987 {

	private static int[] dr = new int[] {-1, 0, 1, 0};
	private static int[] dc = new int[] {0, 1, 0, -1};
	private static char[][] arr;
	private static boolean[] alp;
	
	static int go(int r, int c) {
		if(alp[arr[r][c] - 65])
			return 0;
		alp[arr[r][c] - 65] = true; 
		int max = 0;
		for(int k = 0; k < 4; k++) {
			try {
				int tmp = go(r + dr[k], c + dc[k]);
				if(tmp > max) max = tmp;
			} catch(ArrayIndexOutOfBoundsException e) {}
		}
		alp[arr[r][c] - 65] = false; 
		return max + 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arr = new char[r][];
		alp = new boolean[26];
		for(int i = 0 ; i < r; i++)
			arr[i] = br.readLine().toCharArray();
		System.out.println(go(0, 0));
	}
}