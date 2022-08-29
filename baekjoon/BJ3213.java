import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[3];
		for(int n = 0; n < N; n++) {
			String line = br.readLine();
			if("3/4".equals(line)) {
				arr[0]++;
			} else if("1/2".equals(line)) {
				arr[1]++;
			} else {
				arr[2]++;
			}
		}
		
		int cnt = 0;
		
		cnt += arr[0];
		if(arr[0] >= arr[2]) {
			arr[2] = 0;
		} else {
			arr[2] -= arr[0];
		}
		
		cnt += arr[1] / 2;
		if(arr[1] % 2 != 0) {
			cnt++;
			if(arr[2] <= 2) arr[2] = 0;
			else arr[2] -= 2;
		}
		
		cnt += arr[2] / 4;
		if(arr[2] % 4 != 0) {
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
