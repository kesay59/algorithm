import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25215 {
	public static void main(String[] args) throws IOException {
		String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int[] prev = new int[] {0, 1};
		int[] cur = new int[2];
		int[] tmp;
		for(int idx = 0; idx < line.length(); idx++) {
			if(line.charAt(idx) < 'a') {
				cur[0] = Math.min(prev[0], prev[1]) + 2;
				cur[1] = Math.min(prev[0] + 2, prev[1] + 1);
			} else {
				cur[0] = Math.min(prev[0] + 1, prev[1] + 2);
				cur[1] = Math.min(prev[0], prev[1]) + 2;
			}
			tmp = cur;
			cur = prev;
			prev = tmp;
		}
		System.out.println(Math.min(prev[0], prev[1]));
	}
}
