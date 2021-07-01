import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		StringTokenizer mst = new StringTokenizer(st.nextToken(), "+");
		int tmp = 0;
		int sum = 0;
		while(mst.hasMoreTokens())
			tmp += Integer.parseInt(mst.nextToken());
		while(st.hasMoreTokens()) {
			mst = new StringTokenizer(st.nextToken(), "+");
			while(mst.hasMoreTokens()) 
				sum += Integer.parseInt(mst.nextToken());
		}
		System.out.println(tmp - sum);
	}

}