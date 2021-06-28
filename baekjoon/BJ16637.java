import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16637 {

	private static boolean[] sel;
	private static int[] number;
	private static char[] operator;
	
	private static int maxCul = Integer.MIN_VALUE;
	
	private static void cul(int[] na, char[] oa, boolean[] va, int loc) {
		int f = loc, b = loc + 1;
		for(; b < oa.length; b++) {
			if(!va[b]) break;
		}
		va[f] = true;
		if(oa[f] == '+') na[b] = na[f] + na[b];
		else if(oa[f] == '-') na[b] = na[f] - na[b];
		else na[b] = na[f] * na[b];
	}
	
	private static void select(int dp) {
		if(dp == sel.length) {
			int[] culNumber = number.clone();
			boolean[] vis = new boolean[operator.length];
			
			for(int i = 0; i < sel.length; i++) {
				if(sel[i]) cul(culNumber, operator, vis, i);
			}
			
			for(int i = 0; i < operator.length; i++) {
				if(!vis[i]) cul(culNumber, operator, vis, i);
			}
			
			maxCul = Math.max(maxCul, culNumber[culNumber.length-1]);
			return;
		}
		if(!sel[dp - 1]) {
			sel[dp] = true;
			select(dp + 1);
			sel[dp] = false;
		}
		select(dp + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		if(len == 1) {
			System.out.println(Integer.parseInt(br.readLine()));
			System.exit(0);
		}
		char[] line = br.readLine().toCharArray();
		int cnt = 0;
		number = new int[len / 2 + 1];
		operator = new char[len / 2];
		sel = new boolean[len / 2];
		for(int i = 0; i < len; i++) {
			if(i % 2 == 0) number[i /2] = line[i] - 48;
			else operator[i / 2] = line[i];
		}
		
		
		select(1);
		sel[0] = true;
		select(1);
		
		
		System.out.println(maxCul);
	}

}
