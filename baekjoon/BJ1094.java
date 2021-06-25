import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1094 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int stick = 64;
		int minStick = 64; 
		int cnt = 1;
		while(num != stick) {
			minStick /= 2;
			if(stick - minStick >= num) {
				stick -= minStick;
			}
			else {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
