import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2529 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		Stack<Integer> stk = new Stack<Integer>();
		int len = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().replace(" ", "").toCharArray();
		for (int i = 0; i < len; i++) {
			stk.push(9 - i);
			if (arr[i] == '>')
				while (!stk.isEmpty())
					stb.append(stk.pop());
		}
		stk.push(9 - len);
		while (!stk.isEmpty())
			stb.append(stk.pop());
		stb.append("\n");
		for (int i = 0; i < len; i++) {
			stk.push(i);
			if (arr[i] == '<')
				while (!stk.isEmpty())
					stb.append(stk.pop());
		}
		stk.push(len);
		while (!stk.isEmpty())
			stb.append(stk.pop());
		System.out.println(stb);
	}

}