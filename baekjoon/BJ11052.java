import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] costArray = new int[num + 1];
		int maxCost;
		for(int idx = 1; idx <= num; idx++) {
			maxCost = Integer.parseInt(st.nextToken());
			for(int subIdx = 1; subIdx <= idx / 2; subIdx++) {
				maxCost = Math.max(maxCost, costArray[subIdx] + costArray[idx - subIdx]);
			}
			costArray[idx] = maxCost;
		}
		System.out.println(costArray[num]);
	}
}
