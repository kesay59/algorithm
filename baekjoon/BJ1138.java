import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BJ 1138 한 줄로 서기
public class BJ1138 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] ra = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= len; i++) {
			int inp = Integer.parseInt(st.nextToken());
			int cur = -1;
			while(inp != -1) {
				cur++;
				if(ra[cur] == 0) inp--;
			}
			ra[cur] = i;
		}
		for(int i : ra)
			System.out.print(i + " ");
	}

}
