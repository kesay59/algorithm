import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Stack<Character> stk = new Stack<Character>();
		for(int i = 0; i < num; i++) {
			for(char ch : br.readLine().toCharArray()) {
				if(ch == '(') {
					stk.push(ch);
				} else {
					if(stk.isEmpty()) {
						stk.push(' ');
						break;
					} else {
						stk.pop();
					}
				}
			}
			if(stk.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
			stk.clear();
		}
		
	}
}
