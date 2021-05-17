import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 19575
public class BJ19575 {

	private static int plus(long a, int b) {
		if(a >= 1000000007) a %= 1000000007;
		if(b >= 1000000007) b %= 1000000007;
		return (int) (a + b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		int val = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int ans = Integer.parseInt(st.nextToken());
		
		while(cnt-- != 0) {
			st = new StringTokenizer(br.readLine());
			ans = plus((long)ans*val, Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(ans);
	}

}