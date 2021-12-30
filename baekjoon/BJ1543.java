import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String word = br.readLine();
		int idx = 0;
		int cnt = 0;
		while(idx + word.length() <= doc.length()) {
			if(doc.substring(idx, idx + word.length()).equals(word)) {
				cnt++;
				idx += word.length();
			}
			else {
				idx++;
			}
		}
		System.out.println(cnt);
	}
}
