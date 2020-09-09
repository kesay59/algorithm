import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 문자열압축 {

	public static void main(String[] args) throws IOException {
		char[] line = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		int skip = 0;
		for(int i = line.length / 2; i > 0; i--) {
			int stk = 0;
			int cur = 0;
			boolean change = true;
			int num = 0;
			for(int j = i; j < line.length; j += i) {
				if(check(line, cur, j, i)) {
					if(change) {
						change = false;
						num++;
					}
					stk++;
				} else {
					change = true;
					cur = j;
				}
			}
			skip = Math.max(skip, stk * i - num);
		}
		System.out.println(line.length - skip);
	}

	private static boolean check(char[] line, int i, int j, int len) {
		try {
			for(int k = 0; k < len; k++) 
				if(line[i + k] != line[j + k]) return false;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

}
