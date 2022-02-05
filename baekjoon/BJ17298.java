import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num]; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stk = new Stack<Integer>();
		int tmp;
		for(int i = 0; i < num; i++) {
			int n = Integer.parseInt(st.nextToken());
			while(!stk.isEmpty()) {
				if(stk.peek() < n) {
					stk.pop();
					arr[stk.pop()] = n;
				}
				else {
					stk.push(i);
					stk.push(n);
					break;
				}
			}
			if(stk.isEmpty()) {
				stk.push(i);
				stk.push(n);
			}
		}
		while(!stk.isEmpty()) {
			stk.pop();
			arr[stk.pop()] = -1;
		}
		StringBuilder stb = new StringBuilder();
		for(int n : arr) {
			stb.append(n).append(' ');
		}
		System.out.println(stb);
	}
}
