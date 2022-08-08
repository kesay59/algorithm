import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[][] arr = new int[K+1][2];
		for(int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			arr[k][0] = Integer.parseInt(st.nextToken());
			arr[k][1] = st.nextToken().charAt(0);
		}
		if(arr[Q][0] == 0) {
			System.out.println(-1);
			return;
		}
		int q = Q;
		for(; q > 1; q--) {
			if(arr[q][0] != arr[Q][0]) break;
		}
		q++;
		boolean[] read = new boolean[N];
		read[0] = true;
		for(; q <= K; q++) {
			read[arr[q][1] - 'A'] = true;
		}
		StringBuilder stb = new StringBuilder();
		for(int n = 0; n < N; n++) {
			if(!read[n]) stb.append((char) (n + 'A')).append(' ');
		}
		System.out.println(stb);
	}
}
