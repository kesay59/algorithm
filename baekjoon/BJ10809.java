import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BJ10809 {

	private static int[] alp = new int[123];
	private static int ch = 97;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i =97; i < 123; i++)
			alp[i] = -1;
		
		for(int cur = 0; ch > 96; cur++) {
			ch = System.in.read();
			if(alp[ch] == -1) alp[ch] = cur;
		}
		
		for(int i = 97; i < 122; i++)
			bw.write(alp[i] + " ");
		bw.write(""+alp[122]);
		
		bw.flush();
	}

}