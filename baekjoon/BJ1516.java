import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1516 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean[][] table = new boolean[num][num];
		int[] time = new int[num];
		int[] preCnt = new int[num];
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {				
				int n = Integer.parseInt(st.nextToken());
				if(n == -1) break;
				table[i][n-1] = true;
				preCnt[i]++;
			}
		}
		int[] preTime  = new int[num];
		Stack<Integer> stk = new Stack<Integer>();
		for(int i = 0; i < num; i++) {
			if(preCnt[i]== 0) {
				stk.push(i);
			}
		}
		while(!stk.isEmpty()) {
			int cur = stk.pop();
			for(int i = 0; i < num; i++) {
				if(table[i][cur]) {
					preTime[i] = Math.max(preTime[i], preTime[cur] + time[cur]);
					preCnt[i]--;
					if(preCnt[i] == 0) stk.push(i);
				}
			}
		}
		for(int i = 0; i < num; i++) {
			System.out.println(preTime[i] + time[i]);
		}
	}
}
