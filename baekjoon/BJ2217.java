import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[Integer.parseInt(br.readLine())];
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		int tmp;
		for(int i = 1; i <= arr.length; i++) {
			if(arr[arr.length - i] * arr.length < max) break;
			tmp = arr[arr.length - i] * i;
			if(max < tmp) max = tmp;
		}
		System.out.println(max);
	}

}