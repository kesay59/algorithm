import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		int[] num = new int[2];
		num[0] = Integer.parseInt(st.nextToken());
		num[1] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		int cnt = 1;
		while(num[0] % 2 != 1 || num[0] + 1 != num[1]) {
			num[0] = (num[0] + 1) / 2;
			num[1] = (num[1] + 1) / 2;
			cnt++;
		}
		System.out.println(cnt);
	}
}
