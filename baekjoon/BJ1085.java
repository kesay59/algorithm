import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//직사각형에서 탈출
public class BJ1085 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		System.out.println(Math.min(Math.min(x, Integer.parseInt(st.nextToken())-x), Math.min(y, Integer.parseInt(st.nextToken())-y)));
	}
}
