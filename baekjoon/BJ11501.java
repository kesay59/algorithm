import java.util.StringTokenizer;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11501{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcN = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Integer> stk = new Stack();
		for(int tc = 0; tc < tcN; tc++) {
			int len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < len; i++) 
				stk.push(Integer.parseInt(st.nextToken()));
			int max = stk.pop();
			long sum = 0;
			while(!stk.isEmpty()) {
				int cur = stk.pop();
				if(cur > max) max = cur;
				else sum += max - cur;
			}
			System.out.println(sum);
		}
		

	}

}
