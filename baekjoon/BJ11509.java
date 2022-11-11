import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11509 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			int cur = Integer.parseInt(st.nextToken());
			if(arr[cur] > 0) {
				arr[cur]--;
				arr[cur-1]++;
			} else {
				cnt++;
				arr[cur-1]++;
			}
		}
		System.out.println(cnt);
	}
}
