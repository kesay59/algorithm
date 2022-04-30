import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class BJ2138 {
	private static int find(int num, char[] a, char[] b, int cnt) {
		for(int i = 0; i < num - 2; i++) {
			if(a[i] != b[i]) {
				a[i] = a[i] == '0' ? '1' : '0';
				a[i+1] = a[i+1] == '0' ? '1' : '0';
				a[i+2] = a[i+2] == '0' ? '1' : '0';
				cnt++;
			}
		}
		if(a[num-2] != b[num-2]) {
			a[num-2] = a[num-2] == '0' ? '1' : '0';
			a[num-1] = a[num-1] == '0' ? '1' : '0';
			cnt++;
		}
		if(a[num-1] != b[num-1]) return Integer.MAX_VALUE;
		else return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		char[] a1 = br.readLine().toCharArray();
		char[] a2 = a1.clone();
		a2[0] = a2[0] == '0' ? '1' : '0';
		a2[1] = a2[1] == '0' ? '1' : '0';
		char[] b = br.readLine().toCharArray();
		int answer = Math.min(find(num, a1, b, 0), find(num, a2, b, 1));
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}
