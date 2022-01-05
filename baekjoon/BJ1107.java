import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ1107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		HashSet<Character> brokenBtn = new HashSet<Character>();
		if (num > 0) {
			char[] chArr = br.readLine().replace(" ", "").toCharArray();
			for (char ch : chArr) {
				brokenBtn.add(ch);
			}
		}
		int answer = Math.abs(target - 100);
		int up, down;
		boolean pass;
		for (int i = 0; i <= target || i + target < 100; i++) {
			pass = true;
			down = target - i;
			if(down >= 0) {				
				for (char ch : Integer.toString(down).toCharArray()) {
					if (brokenBtn.contains(ch)) {
						pass = false;
						break;
					}
				}
				if (pass) {
					answer = Math.min(answer, Integer.toString(down).length() + i);
					break;
				}
			}
			pass = true;
			up = target + i;
			for (char ch : Integer.toString(up).toCharArray()) {
				if (brokenBtn.contains(ch)) {
					pass = false;
					break;
				}
			}
			if (pass) {
				answer = Math.min(answer, Integer.toString(up).length() + i);
				break;
			}
		}
		System.out.println(answer);
	}
}