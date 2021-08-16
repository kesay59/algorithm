import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18512 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean vis[] = new boolean[10000];
		
		int m1 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());

		int h1 = Integer.parseInt(st.nextToken());
		int h2 = Integer.parseInt(st.nextToken());
		
		for(; h1 < 10000; h1 += m1)
			vis[h1] = true;
		
		for(; h2 < 10000; h2 += m2) {
			if(vis[h2]) {
				System.out.println(h2);
				break;
			}
		}
        
		if(h2 >= 10000) System.out.println(-1);
	}

}
