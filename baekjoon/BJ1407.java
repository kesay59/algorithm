import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1407 {
	private static long calc(long num) {
		long sum = 0;
		long cnt = 1;
		while(num > 0) {			
			sum += (num + 1) / 2 * cnt;
			cnt *= 2;
			num /= 2;
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long prev = calc(Long.parseLong(st.nextToken()) - 1L);
		long end = calc(Long.parseLong(st.nextToken()));
		System.out.println(end - prev);
	}
}
//f(1) = 1
//f(2) = f(1) * 2
//f(3) = 1
//f(4) = f(2) * 2
//f(5) = 1
//f(6) = f(3) * 2
//f(7) = 1
//f(8) = f(4) * 2
//f(9) = 1
