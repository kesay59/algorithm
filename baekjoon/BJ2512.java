import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < num; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		int maxMoney = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int sum = 0;
		for(int n = 0; n < num; n++) {
			if(sum + (num - n) * arr[n] > maxMoney) {
				System.out.println((maxMoney - sum) / (num - n));
				return;
			} else {
				sum += arr[n];
			}
		}
		System.out.println(arr[num - 1]);
	}
}
