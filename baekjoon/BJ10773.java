import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10773 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		int cur;
		for(int i = 0; i < N; i++) {
		    cur = Integer.parseInt(br.readLine());
		    if(cur == 0) stk.pop();
		    else stk.push(cur);
		}
		int sum = 0;
		while(!stk.isEmpty()) {
		    sum += stk.pop();
		}
		System.out.println(sum);
	}
}
