import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int p = 0;
		for(int i = 0; i < arr.length; i++) {
			if(p + 1 < arr[i]) {
				System.out.println(p + 1);
				return;
			} else {
				p += arr[i];
			}
		}
		System.out.println(p+1);
	}
}
