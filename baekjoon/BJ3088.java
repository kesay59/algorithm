import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3088 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] numbers = new int[3];
		boolean[] isBroken = new boolean[1000001];
		boolean flag;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			flag = false;
			for(int j = 0; j < 3; j++) {
				numbers[j] = Integer.parseInt(st.nextToken());
				if(isBroken[numbers[j]]) flag = true;
			}
			for(int j = 0; j < 3; j++) {				
				isBroken[numbers[j]] = true;
			}
			if(!flag) cnt++;
		}
		System.out.println(cnt);
	}
}
