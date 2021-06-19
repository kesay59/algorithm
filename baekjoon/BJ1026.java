import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1026 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arrA = new int[num];
		int[] arrB = new int[num];
		StringTokenizer stA = new StringTokenizer(br.readLine());
		StringTokenizer stB = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++) {
			arrA[i] = Integer.parseInt(stA.nextToken());
			arrB[i] = Integer.parseInt(stB.nextToken());
		}
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int sum = 0;
		for(int i = 0; i < num; i++) {
			sum += arrA[i] * arrB[num - 1 - i];
		}
		System.out.println(sum);
	}

}
