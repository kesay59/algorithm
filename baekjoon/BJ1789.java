import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003 {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long val = Long.parseLong(br.readLine());
		long sum = 0;
		long i = 1;
		while(true) {
			sum += i;
			if(sum == val) {
				System.out.println(i);
				break;
			}
			else if(sum > val) {
				System.out.println(i - 1);
				break;
			}
			i++;
		}
		
	}
}
