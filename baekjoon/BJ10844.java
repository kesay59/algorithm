import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] table = new int[2][10];
		byte cur = 0;
		Arrays.fill(table[0], 1);
		table[0][0] = 0;
		for(int n = 1; n < num; n++) {
			for(int i = 0; i < 10; i++) {
				if(i == 0) table[cur^1][i] = table[cur][i+1] % 1000000000;
				else if(i == 9) table[cur^1][i] = table[cur][i-1] % 1000000000;
				else table[cur^1][i] = (table[cur][i-1] + table[cur][i+1]) % 1000000000;
			}
			cur ^= 1;
		}
		long answer = 0;
		for(int cnt : table[cur]) answer += cnt;
		System.out.println(answer % 1000000000);
	}
}
