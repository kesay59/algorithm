import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ13164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[num-1];
		int pre = Integer.parseInt(st.nextToken()), cur;
		for(int n = 0; n < num-1; n++) {
			cur = Integer.parseInt(st.nextToken());
			arr[n] = cur - pre;
			pre = cur;
		}
		Arrays.sort(arr);
		for(int c = 1; c < cnt; c++) {
			arr[arr.length-c] = 0;
		}
		int sum = 0;
		for(int n : arr) {
			sum += n;
		}
		System.out.println(sum);
	}
}
