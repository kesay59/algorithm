import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BJ 12865 평범한 배낭
public class BJ12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int weight = Integer.parseInt(st.nextToken());
		int[] arr = new int[weight + 1];
		for(int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			for(int l = weight; l - w >= 0; l--) 
				if(arr[l-w] + v > arr[l]) arr[l] = arr[l-w] + v;
		}
		System.out.println(arr[weight]);
	}
}
