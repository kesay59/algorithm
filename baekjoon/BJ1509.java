import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1509 {
	public static void main(String[] args) throws IOException {
		String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
		boolean[][] table = new boolean[line.length()][line.length()];
		for(int j = 0; j < line.length(); j++) {
			table[j][j] = true;
		}
		for(int j = 1; j < line.length(); j++) {
			if(line.charAt(j-1) == line.charAt(j)) table[j-1][j] = true;
		}
		for(int k = 2; k < line.length(); k++) {
			for(int j = k; j < line.length(); j++) {
				if(line.charAt(j-k) == line.charAt(j) && table[j-k+1][j-1]) table[j-k][j] = true;
			}
		}
		
		int[] minMemo = new int[line.length()];
		Arrays.fill(minMemo, Integer.MAX_VALUE);
		for(int j = 0; j < line.length(); j++) {
			for(int i = 0; i <= j; i++) {
				if(table[i][j]) {
					if(i == 0) {
						minMemo[j] = 1;
					} else {
						minMemo[j] = Math.min(minMemo[j], minMemo[i-1] + 1);
					}
				}
			}
		}
		System.out.println(minMemo[line.length()-1]);
	}
}