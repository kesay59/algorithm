import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			char ch;
			while(st.hasMoreTokens()) {
				ch = st.nextToken().charAt(0);
				if(word.charAt(0) < ch) word = word + ch;
				else word = ch + word;
			}
			System.out.println(word);
		}
	}
}
