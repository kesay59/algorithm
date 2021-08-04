import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int bot = 0, top = Integer.MAX_VALUE;
		int h = Integer.MAX_VALUE / 2;
		while(true) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(arr[i] > h) sum += arr[i] - h;
				if(sum < 0 || sum >= M) {
					bot = h;
					h = h + (top - h) / 2;
					break;
				}
			}
			if(sum >= 0 && sum < M) {
				top = h;
				h = bot + (h - bot) / 2;
			}
			if(bot >= top - 1) {
				System.out.println(bot);
				System.exit(0);
			}
		}
	}
}
