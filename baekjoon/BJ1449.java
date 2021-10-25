import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] holeArray = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			holeArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(holeArray);
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int leng = L;
			while(i + 1 < N && holeArray[i+1] - holeArray[i] < leng) {
				leng -= holeArray[i+1] - holeArray[i];
				i++;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
