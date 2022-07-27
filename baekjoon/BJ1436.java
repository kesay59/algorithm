import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long number = 666L;
		String numberStr;
		int cnt = 0;
		out : while(cnt < N) {
			numberStr = Long.toString(number);
			int c = 0;
			for(int i = 0; i < numberStr.length(); i++) {
				if(numberStr.charAt(i) == '6') {
					c++;
					if(c == 3) {
						cnt++;
						break;
					}
				} else {
					c = 0;
				}
			}
			number++;
		}
		System.out.println(number - 1);
	}
}
