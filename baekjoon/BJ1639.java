import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1639 {
	public static void main(String[] args) throws IOException {
		String ticket = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int maxLen = 0;
		for(int k = 0; k < ticket.length(); k++) {
			int sumF = 0, sumB = 0;
			for(int i = k, j = i + 1; j < ticket.length(); i++, j+=2) {
				sumF += ticket.charAt(i);
				sumB += -ticket.charAt(i) + ticket.charAt(j-1) + ticket.charAt(j);
				if(sumF == sumB) maxLen = Math.max(maxLen, (i - k + 1) * 2);
			}
		}
		System.out.println(maxLen);
	}
}
