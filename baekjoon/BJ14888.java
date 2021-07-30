import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {
	private static int N;
	private static int[] arr;
	private static int[] selArr;
	private static int[] op = new int[4];
	private static int maxVal = Integer.MIN_VALUE;
	private static int minVal = Integer.MAX_VALUE;
	
	private static void bfSearch(int idx) {
		if(idx + 1 == N) {
			int result = arr[0];
			for(int i = 0; i < selArr.length; i++) {
				if(selArr[i] == 0) result += arr[i+1];
				else if(selArr[i] == 1)result -= arr[i+1];
				else if(selArr[i] == 2)result *= arr[i+1];
				else result /= arr[i+1];
			}
			minVal = Math.min(minVal, result);
			maxVal = Math.max(maxVal, result);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				selArr[idx] = i;
				bfSearch(idx + 1);
				op[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		selArr = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		bfSearch(0);
		System.out.println(maxVal);
		System.out.println(minVal);
	}
}
