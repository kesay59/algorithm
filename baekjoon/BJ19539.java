import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19539 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		int oddCnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len;
		for(int i = 0; i < num; i++) {
			len = Integer.parseInt(st.nextToken());
			if(len % 2 == 1) oddCnt++;
			sum += len;
		}
		System.out.println(sum % 3 == 0 && oddCnt <= sum / 3 ? "YES" : "NO");
	}
}
