import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1120 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		char[] aArr = st.nextToken().toCharArray();
		char[] bArr = st.nextToken().toCharArray();
		int gap = bArr.length - aArr.length;
		int cnt;
		int min = 50;
		for(int i = 0; i < gap + 1; i++) {
			cnt = 0;
			for(int j = 0; j < aArr.length; j++)
				if(aArr[j] == bArr[i+j]) cnt++;
			if(aArr.length - cnt < min) min = aArr.length - cnt;
		}
		System.out.println(min);
	}
	
}