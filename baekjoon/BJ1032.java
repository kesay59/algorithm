import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] answer = br.readLine().toCharArray();
		for(int n = 1; n < N; n++) {
			String line = br.readLine();
			for(int idx = 0; idx < line.length(); idx++) {
				if(answer[idx] != line.charAt(idx)) answer[idx] = '?';
			}
		}
		System.out.println(new String(answer));
	}
}
