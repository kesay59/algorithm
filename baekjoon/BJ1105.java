import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1105 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		if(num[0].length() != num[1].length()) {
			System.out.println(0);
		}
		else {
			int cnt = 0;
			for(int i = 0; i < num[0].length(); i++) {
				if(num[0].charAt(i) == num[1].charAt(i)) {
					if(num[0].charAt(i) == '8') cnt++;
				} else {
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}
