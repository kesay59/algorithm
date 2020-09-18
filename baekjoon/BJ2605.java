import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ2605 {
	//백준 2605 줄 세우기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> ll = new LinkedList<>();
		int len = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < len; i++) {
			ll.add(i-Integer.parseInt(st.nextToken()), i + 1);
		}
		for(int i : ll)
			System.out.print(i + " ");
	}
}
