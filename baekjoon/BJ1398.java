import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1398 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[101];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		arr[1] = 1;
		arr[10] = 1;
		arr[25] = 1;
		arr[100] = 1;
		for(int i = 2; i < 100; i++) 
			for(int j = 1; j < i; j++) 
				arr[i] = Math.min(arr[i], arr[j] + arr[i-j]);
		
		int tcN = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < tcN; tc++) {
			long inp = Long.parseLong(br.readLine());
			int cnt = 0;
			while(inp != 0) {
				cnt += arr[(int) (inp % Long.parseLong("100"))];
				inp /= Long.parseLong("100");
			}
			System.out.println(cnt);
			
		}
	}
}
