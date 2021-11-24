import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] heightArr = new int[num + 1]; 
		Stack<Integer> topIdxStack = new Stack<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder stb = new StringBuilder();
		for(int n = 1; n <= num; n++) {
			heightArr[n] = Integer.parseInt(st.nextToken());
			while(!topIdxStack.isEmpty()) {
				if(heightArr[topIdxStack.peek()] > heightArr[n]) {
					stb.append(topIdxStack.peek()).append(' ');
					topIdxStack.push(n);
					break;
				}
				else if(heightArr[topIdxStack.peek()] == heightArr[n]) {
					stb.append(topIdxStack.peek()).append(' ');
					topIdxStack.pop();
					topIdxStack.push(n);
					break;
				}
				else {
					topIdxStack.pop();
				}
			}
			if(topIdxStack.isEmpty()) {
				stb.append(0).append(' ');
				topIdxStack.push(n);
			}
		}
		System.out.println(stb);
	}
}
