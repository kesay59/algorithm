import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		for(int i = 3; i < 10; i++)
			arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
		int len = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < len; i++) 
			System.out.println(arr[Integer.parseInt(br.readLine())-1]);
	}

}