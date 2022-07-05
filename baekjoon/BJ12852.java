import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ12852 {
	private static int[] memo;
	private static Queue<Integer> answerQue;
	
	private static void calc(Stack<Integer> stk) {
		int num = stk.peek();
		if(stk.size() >= memo[num]) return;
		memo[num] = stk.size();
		if(num == 1) {
			answerQue = new LinkedList<Integer>();
			Stack<Integer> tmp = new Stack<Integer>();
			while(!stk.isEmpty()) {
				tmp.push(stk.pop());
			}
			int cur;
			while(!tmp.isEmpty()) {
				cur = tmp.pop();
				answerQue.offer(cur);
				stk.push(cur);
			}
			return;
		}
		if(num % 3 == 0) {
			stk.push(num / 3);
			calc(stk);
			stk.pop();
		}
		if(num % 2 == 0) {
			stk.push(num / 2);
			calc(stk);
			stk.pop();
		}
		stk.push(num - 1);
		calc(stk);
		stk.pop();
	}
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		memo = new int[N + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(N);
		calc(stk);
		StringBuilder stb = new StringBuilder();
		stb.append(answerQue.size()-1).append('\n');
		stb.append(answerQue.poll());
		while(!answerQue.isEmpty()) {
			stb.append(' ').append(answerQue.poll());
		}
		System.out.println(stb.toString());
	}
}
