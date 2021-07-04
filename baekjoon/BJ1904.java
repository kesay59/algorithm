import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BJ1904 {

	public static void main(String[] args) throws IOException{
		int input = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] lut = new int[input];
		if(input == 1) System.out.print(1);
		else {
			lut[0] = 1;
			lut[1] = 2;
			for(int i = 2 ; i < input; i++) {
				lut[i] = lut[i-1] + lut[i-2];
				if(lut[i] >= 15746) lut[i] -= 15746;
			}
			System.out.print(lut[input - 1]);
		}
	}

}
