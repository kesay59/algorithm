import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1062 {
	static char[][] words;
	static boolean[] selArr;
	static int N, K, maxRw = 0;
	
	private static void check(int alp, int cnt) {
		if(cnt == K) {
			if(selArr['a'] && selArr['c'] && selArr['i'] && selArr['n'] && selArr['t']) {
				int rw = 0;
				for(char[] word : words) {
					int i = 4;
					for(; i < word.length-4; i++ ) {
						if(!selArr[word[i]]) break;
					}
					if(i == word.length-4) rw++;
				}
				maxRw = Math.max(maxRw, rw);
			}
			return;
		}
		for(int i = alp + 1; i <= 'z'; i++) {
			selArr[i] = true;
			check(i, cnt+1);
			selArr[i] = false;
			if(i == 'a' || i == 'c' || i == 'n' || i == 't') return;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		selArr = new boolean[123];
		words = new char[N][];
		for(int n = 0; n < N; n++) {
			words[n] = br.readLine().toCharArray();
		}
		
		check('a'-1, 0);
		System.out.println(maxRw);
	}
}
