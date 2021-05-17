import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 19572 가뭄
public class BJ19572 {

	static double eps = 0.00000001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());

		double a = (x + y - z) / 2.0;
		double b = (x - y + z) / 2.0;
		double c = (-x + y + z) / 2.0;
		if(a > 0 && b > 0 && c > 0 && Math.abs(a + b - x) < eps && Math.abs(a + c - y) < eps && Math.abs(b + c - z) < eps) System.out.println("1\n"+String.format("%.1f %.1f %.1f", a, b, c));
		else System.out.println(-1);
	}

}
