import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int n = 1; n <= N; n++) {
			String num = Integer.toString(n);
			int dif = num.length() > 1 ? num.charAt(0) - num.charAt(1) : 0;
			int l = 1;
			for(; l < num.length(); l++) {
				if(num.charAt(l-1) - num.charAt(l) != dif) break;
			}
			if(l == num.length()) cnt++;
		}
		System.out.println(cnt);
	}
}
