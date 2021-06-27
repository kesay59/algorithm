import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16639 {
	
	private static int maxSum = Integer.MIN_VALUE;
	
	private static int[] number;
	private static char[] operator;
	private static boolean[] visit;
	
	private static void cul(int dp) {
		if(dp == operator.length) {
			maxSum = Math.max(maxSum, number[number.length-1]);
		}
		for(int i = 0; i < operator.length; i++) {
			if(visit[i]) continue;
			int f = i, b = i + 1;
			for(; b < operator.length; b++) {
				if(!visit[b]) break;
			}
			
			int tmpF = number[f];
			int tmpB = number[b];
			
			visit[i] = true;
			if(operator[i] == '+') number[b] = number[f] + number[b];
			else if(operator[i] == '-') number[b] = number[f] - number[b];
			else number[b] = number[f] * number[b];
			
			cul(dp + 1);
			
			visit[i] = false;
			number[f] = tmpF;
			number[b] = tmpB;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		char[] line = br.readLine().toCharArray();
		int cnt = 0;
		number = new int[len / 2 + 1];
		operator = new char[len / 2];
		visit = new boolean[len / 2];
		for(int i = 0; i < len; i++) {
			if(i % 2 == 0) number[i /2] = line[i] - 48;
			else operator[i / 2] = line[i];
		}
		cul(0);
		System.out.println(maxSum);
	}
}
