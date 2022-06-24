import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1759 {
	private static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
	private static void dfs(char[] alps, int idx, String pw, int cntV, int cntC, int lim, StringBuilder answer) {
		if(pw.length() == lim) {
			if(cntV >= 1 && cntC >= 2) answer.append(pw).append('\n');
			return;
		}
		for(; idx < alps.length; idx++) {
			if(vowels.contains(alps[idx])) dfs(alps, idx + 1, pw + alps[idx], cntV + 1, cntC, lim, answer);
			else dfs(alps, idx + 1, pw + alps[idx], cntV, cntC + 1, lim, answer);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lim = Integer.parseInt(st.nextToken());
		char[] alps = br.readLine().replaceAll(" ", "").toCharArray();
		Arrays.sort(alps);
		StringBuilder answer = new StringBuilder();
		dfs(alps, 0, "", 0, 0, lim, answer);
		System.out.println(answer.toString());
	}
}
