import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out : while(true) {
			String line = br.readLine();
			if(line.length() == 1 && line.charAt(0) == '.') break;
			Stack<Character> stk = new Stack<Character>();
			for(char ch : line.toCharArray()) {
				if(ch == '(' || ch == '[') {
					stk.push(ch);
				} else if(ch == ')') {
					if(stk.isEmpty() || stk.pop() != '(') {
						System.out.println("no");
						continue out;
					}
				} else if(ch == ']') {
					if(stk.isEmpty() || stk.pop() != '[') {
						System.out.println("no");
						continue out;
					}
				}
			}
			if(stk.isEmpty()) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
