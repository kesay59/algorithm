import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ9237 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int maxDay = 0, day = 1;
		for(int idx = num - 1; idx >= 0; idx--) {
			if(arr[idx] + day > maxDay) maxDay = arr[idx] + day;
			day++;
		}
		System.out.println(maxDay + 1);
	}
}
