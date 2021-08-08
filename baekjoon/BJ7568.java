import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[num][];
		
		StringTokenizer st;
		for(int n = 0; n < num; n++) {
			st = new StringTokenizer(br.readLine());
			arr[n] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		int sum;
		for(int n = 0; n < num; n++) {
			sum = 1;
			for(int m = 0; m < num; m++) {
				if(arr[n][0] < arr[m][0] && arr[n][1] < arr[m][1]) sum++;
			}
			System.out.print(sum + " ");
		}

	}

}
