import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cur = new int[N];
		int[] target = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			cur[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			target[n] = Integer.parseInt(st.nextToken());
		}
		
		int p1 = 0, p2, sta;
		for(sta = 0; sta < N; sta++) {
			if(cur[sta] == target[p1]) break;
		}
		
		int n = 0;
		p2 = sta;
		for(; n < N; n++, p1++) {
			if(cur[p2] != target[p1]) break;
			if(++p2 >= N) p2 = 0;
		}
		if(n == N) {
			System.out.println("good puzzle");
			return;
		}
		
		n = 0;
		p1 = 0;
		p2 = sta;
		for(; n < N; n++, p1++) {
			if(cur[p2] != target[p1]) break;
			if(--p2 < 0) p2 = N - 1;
		}
		if(n == N) {
			System.out.println("good puzzle");
			return;
		}
		
		System.out.println("bad puzzle");
	}
}
