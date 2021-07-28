import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4796 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 0) break;
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			System.out.println("Case " + cnt++ + ": " + ((c / b) * a + Math.min(a, c % b)));
		}
	}
}
