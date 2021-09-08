import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11047 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		int[] arr = new int[num];
		int cnt = 0;
		for(int i = 0 ; i< num; i++)
			arr[i] = Integer.parseInt(br.readLine());
		for(int i = num - 1; i >= 0; i--) 
			while(sum >= arr[i]) {
				sum -= arr[i];
				cnt++;
			}
		System.out.println(cnt);
	}

}