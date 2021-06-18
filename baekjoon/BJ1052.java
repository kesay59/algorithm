import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1052 {
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		int add = -1;
		do {
			add++;
			count = 0;
			int bt = N + add;
			while(bt != 0) {
				if(bt % 2 == 1) {
					count++;
					bt--;
				} 
				bt /= 2;
			}
		} while(count > K);		
		System.out.println(add);
	}

}
