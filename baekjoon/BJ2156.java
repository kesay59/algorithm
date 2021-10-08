import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num == 1) {
			System.out.println(Integer.parseInt(br.readLine()));
			System.exit(0);
		}
		int[] amountList = new int[num + 1];
		int[] maxAmountList = new int[num + 1];
		amountList[1] = Integer.parseInt(br.readLine());
		maxAmountList[1] = amountList[1];
		amountList[2] = Integer.parseInt(br.readLine());
		maxAmountList[2] = amountList[1] + amountList[2];
		for(int idx = 3; idx <= num; idx++) {
			amountList[idx] = Integer.parseInt(br.readLine());
			maxAmountList[idx] = Math.max(Math.max(maxAmountList[idx-1], maxAmountList[idx-2] + amountList[idx]), maxAmountList[idx-3] + amountList[idx-1] + amountList[idx]);
		}
		System.out.println(maxAmountList[num]);
	}
}