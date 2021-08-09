import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//ÆÓ¸°µå·Ò ¼ö
public class BJ1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr;
		int idx;
		Stack<Character> stk = new Stack<Character>();
		String line = br.readLine();
		out : while(!"0".equals(line)) {
			arr = line.toCharArray();
			idx = 0;
			for(; idx < arr.length / 2; idx++) 
				stk.push(arr[idx]);
			
			if(arr.length % 2 == 1) idx++;
			for(; idx < arr.length; idx++) 
				if(stk.isEmpty() || stk.pop() != arr[idx]) break;
			
			if(idx == arr.length) System.out.println("yes");
			else System.out.println("no");
			line = br.readLine();
		}
	}
}
