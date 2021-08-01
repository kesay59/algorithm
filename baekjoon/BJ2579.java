import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		if(len == 1) {
			System.out.println(Integer.parseInt(br.readLine()));
			System.exit(0);
		}
		int[] hei = new int[len];
		for(int i = 0; i < len; i++)
			hei[i] = Integer.parseInt(br.readLine());
		int[] arr = new int[len + 1];
		arr[1] = hei[0];
		arr[2] = hei[1] + hei[0];
		for(int i = 3; i < len + 1; i++) 
			arr[i] = hei[i-1] + Math.max(hei[i-2] + arr[i-3] , arr[i-2]);
		System.out.println(arr[len]);
	}

}