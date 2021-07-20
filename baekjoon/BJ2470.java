import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int minIdx = 0, maxIdx = num - 1;
		int btmIdx = 0, topIdx = num - 1;
		int sum;
		int minSum = Integer.MAX_VALUE;
		while(arr[btmIdx] < arr[topIdx]) {
			sum = arr[btmIdx] + arr[topIdx];
			if(Math.abs(sum) < minSum) {
				minSum = Math.abs(sum);
				minIdx = btmIdx;
				maxIdx = topIdx;
			}
			
			if(sum < 0) btmIdx++;
			else if(sum > 0) topIdx--;
			else break;
		}
		System.out.println(arr[minIdx] + " " + arr[maxIdx]);
	}
}
