import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074 {

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int num = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int std, cnt, loc;
		while(num > 0) {
			num--;
			std = (int)Math.pow(2, num);
			cnt = (int)Math.pow(4, num);
			loc = 0;
			
			if(row >= std) {
				loc += 2;
				row -= std;
			}
			if(col >= std) {
				loc += 1;
				col -= std;
			}
			
			sum += cnt * loc;
		}
		System.out.println(sum);
	}

}

