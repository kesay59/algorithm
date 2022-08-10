import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class BJ15927 {
	public static void main(String[] args) throws IOException {
		String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
		boolean check = true;
		for(int i = 1; i < line.length(); i++) {
			if(line.charAt(i) != line.charAt(0)) {
				check = false;
				break;
			}
		}
		if(check) {
			System.out.println(-1);
			return;
		}
		check = true;
		int start = line.length() / 2 - 1, end = (line.length() + 1) / 2;
		for(; start >= 0; start--, end++) {
			if(line.charAt(start) != line.charAt(end)) {
				check = false;
				break;
			}
		}
		System.out.println(check ? line.length() - 1 : line.length());
	}
}
