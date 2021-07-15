import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2491{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().replace(" ", "").toCharArray();
		int max = 0;
		int asc = 0;
		int desc = 0;
		int pre = arr[0];
		for(int i = 0; i < len; i++) {
			if(pre == arr[i]) {
				asc++;
				desc++;
			} else if(pre > arr[i]) {
				desc++;
				max = Math.max(max, asc);
				asc = 1;
			} else {
				asc++;
				max = Math.max(max, desc);
				desc = 1;
			}
			pre = arr[i];
		}
		max = Math.max(max, Math.max(asc, desc));
		System.out.println(max);
	}
}