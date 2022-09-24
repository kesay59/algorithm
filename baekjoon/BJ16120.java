import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ16120 {
	private static void exit(String result) {
		System.out.println(result);
		System.exit(0);
	}
	public static void main(String[] args) throws IOException {
		String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
		Deque<Character> dq = new ArrayDeque<Character>();
		dq.offer('P');
		char cur;
		for(int n = 0; n < line.length() - 1; n++) {
			if(dq.isEmpty()) exit("NP");
			cur = dq.poll();
			if(cur != line.charAt(n)) exit("NP");
			
			if(line.charAt(n) == 'P' && line.charAt(n+1) == 'P') {
				if(dq.isEmpty() || dq.peek() != 'P') {
					dq.offerFirst('P');
					dq.offerFirst('A');
					dq.offerFirst('P');					
				}
			}
		}
		if(dq.size() != 1 || line.charAt(line.length()-1) != dq.poll()) exit("NP");
		exit("PPAP");
	}
}
