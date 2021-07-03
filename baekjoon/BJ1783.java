import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1783 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int answer = 1;
		if (width < 7) {
			if (height == 1) ;
			else if (height == 2) {
				answer += (width-1) / 2;
			} else {
				answer += (width-1);
				if (answer > 4)	answer = 4;
			}
		} else {
			if(height == 1);
			else if(height == 2) {
				answer += (width-1) / 2;
				if (answer > 4)	answer = 4;
			}
			else {
				answer += 4;
				answer += (width-7);
			}

		}

		System.out.println(answer);
	}
}