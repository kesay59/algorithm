import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7570 {

	//BJ 7570 줄 세우기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		int[] check = new int[len + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < len; i++) {
			int tmp = Integer.parseInt(st.nextToken()); 
			check[tmp] = check[tmp-1] + 1;
		}
		int ans = 1;
		for(int i = 1; i <= len; i++) 
			ans = Math.max(ans, check[i]);
		System.out.println(len - ans);
	}

}
