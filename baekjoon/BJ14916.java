import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class BJ14916 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if(N == 1 || N == 3) {
			System.out.println(-1);
			return;
		}
		int cnt5 = N / 5;
		int rm = N % 5;
		if(rm % 2 == 1) {
			cnt5--;
			rm += 5;
		}
		int cnt2 = rm / 2;
		System.out.println(cnt5 + cnt2);
	}
}
