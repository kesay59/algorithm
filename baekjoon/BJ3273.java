import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num == 1) {
			System.out.println(0);
			return;
		}
		int[] arr = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int target = Integer.parseInt(br.readLine());
		int cnt = 0;
		int i = 0, j = arr.length-1, sum;
		while(i < j) {
			sum = arr[i] + arr[j];
			if(sum > target) {
				j--;
			} else if(sum < target) {
				i++;
			} else {
				cnt++;
				if(arr[i] == arr[i+1]) i++;
				else if(arr[j] == arr[j-1]) j--;
				else i++;
			}
		}
		System.out.println(cnt);
	}
}	
