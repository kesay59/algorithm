import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<Integer>();
		int cur = 1;
		StringBuilder stb = new StringBuilder();
		for(int cnt = 0; cnt < N; cnt++) {
			int target = Integer.parseInt(br.readLine());
			while(cur <= N) {
				if(stk.isEmpty() || stk.peek() != target) {
					stk.push(cur++);
					stb.append('+').append('\n');
				} else {
					break;
				}
			}
			if(stk.isEmpty() || stk.peek() != target) {
				System.out.println("NO");
				return;
			} else {
				stk.pop();
				stb.append('-').append('\n');
			}
		}
		System.out.println(stb.toString());
	}
}
