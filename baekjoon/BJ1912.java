import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num == 1) {
			System.out.println(br.readLine());
			System.exit(0);
		}
		
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < num; n++) {
			sum += Integer.parseInt(st.nextToken());
			maxSum = Math.max(maxSum, sum);
			if(sum < 0) sum = 0;
		}
		System.out.println(maxSum);
		
	}
}
