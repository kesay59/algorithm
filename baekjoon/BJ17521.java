import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17521 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long W = Long.parseLong(st.nextToken());
		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		for(int n = 1; n < N; n++) {
			if(arr[n-1] < arr[n]) W += W / arr[n-1] * (arr[n] - arr[n-1]);
		}
		System.out.println(W);
	}
}
