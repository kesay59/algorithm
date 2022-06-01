import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11497 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[num];
			for(int n = 0; n < num; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int[] sArr = new int[num];
			sArr[0] = arr[0];
			int f = 1, b = num - 1;
			for(int n = 1; n < num; f++, b--) {
				sArr[f] = arr[n++];
				if(n == num) break;
				sArr[b] = arr[n++];
			}
			
			int maxVal = Math.abs(sArr[num - 1] - sArr[0]);
			for(int n = 1; n < num; n++) {
				maxVal = Math.max(maxVal, Math.abs(sArr[n] - sArr[n-1]));
			}
			System.out.println(maxVal);
		}
	}
}
