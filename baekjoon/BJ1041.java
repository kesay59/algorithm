import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1041 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dice = new int[6];
		for(int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		if(num == 1) {
			int sum = 0;
			int max = 0;
			for(int i = 0; i < 6; i++) {
				sum += dice[i];
				if(max < dice[i]) max = dice[i];
			}
			System.out.println(sum-max);
			System.exit(0);
		}
		
		long min1 = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++) {
			if(min1 > dice[i]) min1 = dice[i];
		}
		
		long min2 = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++) {
			for(int j = i + 1; j < 6; j++) {
				if(i == 5 - j) continue;
				if(min2 > dice[i] + dice[j]) min2 = dice[i] + dice[j];
			}
		}
		
		long min3 = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++) {
			for(int j = i + 1; j < 6; j++) {
				for(int k = j + 1; k < 6; k++) {
					if(i == 5 - j || i == 5 - k || j == 5 - k) continue;
					if(min3 > dice[i] + dice[j] + dice[k]) min3 = dice[i] + dice[j] + dice[k];
				}
			}
		}
		
		long sum = 0;
		sum += (num-2) * (num-2) * min1 + (num-2) * (num-1) * 4 * min1;
		sum += (num-2) * 4 * min2 + (num-1) * 4 * min2;
		sum += 4 * min3;
		System.out.println(sum);

	}

}
