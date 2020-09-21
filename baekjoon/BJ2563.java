import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2563 색종이
public class BJ2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] arr = new boolean[100][100];
		int len = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt = 0;
		for(int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int m = 0; m < 10; m++) {
				for(int n = 0; n < 10; n++) {
					if(arr[y + m][x + n]) continue;
					arr[y + m][x + n] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
