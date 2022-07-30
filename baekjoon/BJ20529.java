import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20529 {
	private static int calcLeng(String a, String b) {
		int cnt = 0;
		for(int d = 0; d < 4; d++) {
			if(a.charAt(d) != b.charAt(d)) cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] word = new String[N];
			for(int n = 0; n < N; n++) {
				word[n] = st.nextToken();
			}

			int min = Integer.MAX_VALUE;
			int sum = 0;
			out : for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					sum = calcLeng(word[i], word[j]);
					for(int k = j + 1; k < N; k++) {
						min = Math.min(min, sum + calcLeng(word[j], word[k]) + calcLeng(word[k], word[i]));
						if(min == 0) break out;
					}
				}
			}
			System.out.println(min);
		}
	}
}
