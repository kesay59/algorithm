import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2117 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int w = 0;
		for(int n = 2; n <= N; n++) {
			cnt += w;
			if(n % 2 == 0) w++;
		}
		System.out.println(cnt);
	}
}
