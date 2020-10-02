import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BJ 10162 전자레인지
public class BJ1138 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num % 10 != 0) {
			System.out.println(-1);
			System.exit(0);
		}
		int[] bt = new int[] {300, 60, 10};
		for(int k = 0; k < 3; k++) {
			int cnt = 0;
			while(num >= bt[k]) {
				num -= bt[k];
				cnt++;
			}
			System.out.print(cnt + " ");
		}
	}

}
