import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3135 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int min = Math.abs(B - A);
		for(int i = 0; i < N; i++) {
			min = Math.min(Math.abs(B - Integer.parseInt(br.readLine())) + 1, min);
		}
		System.out.println(min);
	}
}
