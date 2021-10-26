import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ2847 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] scoreArray = new int[num];
		for(int i = 0; i < num; i++) {
			scoreArray[i] = Integer.parseInt(br.readLine());
		}
		int sum = 0;
		for(int i = num - 2; i >= 0; i--) {
			if(scoreArray[i] >= scoreArray[i+1]) {
				sum += scoreArray[i] - scoreArray[i+1] + 1;
				scoreArray[i] = scoreArray[i+1] - 1;
			}
		}
		System.out.println(sum);
	}
}
