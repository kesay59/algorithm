import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ11256 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int candy = Integer.parseInt(st.nextToken());
			int box = Integer.parseInt(st.nextToken());
			Integer[] arr = new Integer[box];
			for(int i = 0; i < box; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for(int k = box - 1; k >= 0; k--) {
				candy -= arr[k];
				if(candy <= 0) {
					System.out.println(box - k);
					break;
				}
			}
		}
	}
}
