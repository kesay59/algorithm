import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1965 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int[] maxValue = new int[N+1];
		for(int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		for(int n = 1; n <= N; n++) {
			for(int k = n - 1; k >= 0; k--) {
				if(arr[k] < arr[n]) {
					if(maxValue[k] + 1 > maxValue[n]) maxValue[n] = maxValue[k] + 1;
				}
				if(arr[k] + 1 == arr[n]) break;
			}
		}
		int answer = 0;
		for(int n = 1; n <= N; n++) {
			answer = Math.max(maxValue[n], answer);
		}
		System.out.println(answer);
	}
}
