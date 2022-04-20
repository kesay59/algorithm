import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i = arr.length-1; i > 1; i--) {
			if(arr[i] < arr[i-1] + arr[i-2]) {
				System.out.println(arr[i] + arr[i-1] + arr[i-2]);
				return;
			}
		}
		System.out.println(-1);
	}
}
