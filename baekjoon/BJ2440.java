import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class Main { 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        for(int n = N; n > 0; n--) {
           for(int k = 0; k < n; k++) {
               System.out.print('*');
           }
           System.out.println();
		}
	}
}
