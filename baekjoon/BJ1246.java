import java.io.*;
import java.util.*;

public class BJ1246 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		for(int m = 0; m < M; m++) {
			arr[m] = Integer.parseInt(br.readLine());
		}
		arr = Arrays.stream(arr).sorted().skip(M > N ? M - N : 0).toArray();
		int maxIdx = 0;
		for(int i = 1; i < arr.length; i++) {
			if((arr.length - maxIdx) * arr[maxIdx] < (arr.length - i) * arr[i]) {
				maxIdx = i;
			}
		}
		System.out.printf("%d %d", arr[maxIdx], (arr.length - maxIdx) * arr[maxIdx]);
	}
}
