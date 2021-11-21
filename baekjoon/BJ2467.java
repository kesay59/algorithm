import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] solutions = new int[num];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(solutions);
		int minIdx = 0, maxIdx = num - 1, ans = Integer.MAX_VALUE, cur = Integer.MAX_VALUE;
		int[] ansArr = new int[2];
		while(minIdx < maxIdx) {
			cur = solutions[maxIdx] + solutions[minIdx];
			if(ans > Math.abs(cur)) {
				ans = Math.abs(cur);
				ansArr[0] = solutions[minIdx];
				ansArr[1] = solutions[maxIdx];
			}
			if(cur > 0) maxIdx--;
			else if(cur < 0) minIdx++;
			else break;
		}
		System.out.println(ansArr[0] + " " + ansArr[1]);
	}
}
