import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		for(int n = 0; n < 9; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		int maxIdx = 0;
		for(int idx = 1; idx < 9; idx++) {
			if(arr[idx] > arr[maxIdx]) maxIdx = idx;
		}
		System.out.println(arr[maxIdx]);
		System.out.println(maxIdx + 1);
	}
}
