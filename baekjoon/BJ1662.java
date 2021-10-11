import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1662 {

	private static String str;
	private static int idx;
	
	private static int unzip() {
		idx--;
		int lenSum = 0;
		while(idx >= 0) {			
			if(str.charAt(idx) == ')') {
				lenSum += unzip();
			}
			else if(str.charAt(idx) == '(') {
				idx--;
				return (str.charAt(idx--) - '0') * lenSum;
			}
			else {
				lenSum++;
				idx--;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		idx = str.length() - 1;
		int lenSum = 0;
		while(idx >= 0) {
			if(str.charAt(idx) == ')') {
				lenSum += unzip();
			}
			else {
				lenSum++;
				idx--;
			}
		}
		System.out.println(lenSum);
	}

}
