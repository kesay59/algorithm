import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ2473 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int a = 0, b = 0, c = 0;
		long min = Long.MAX_VALUE, sum = 0, pre = Long.MAX_VALUE;
		int up, down, mid;
		for(int i = 0; i < num - 2; i++) {
			for(int j = i + 1; j < num - 1; j++) {
				sum = arr[i] + arr[j];
				pre = Integer.MAX_VALUE;
				down = j + 1;
				up = num - 1;
				mid = down + (up - down) / 2;
				while(up - down > 1) {
					if(sum + arr[mid] > 0) up = mid;
					else down = mid;
					mid = down + (up - down) / 2;
				}
				if(min > Math.abs(sum + arr[up])) {
					min = Math.abs(sum + arr[up]);
					a = i;
					b = j;
					c = up;
				}
				if(min > Math.abs(sum + arr[down])) {
					min = Math.abs(sum + arr[down]);
					a = i;
					b = j;
					c = down;
				}
			}
		}
		System.out.printf("%d %d %d", arr[a], arr[b], arr[c]);
	}
}
