import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ16206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arrY = new ArrayList<>();
		ArrayList<Integer> arrN = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int bread;
		for(int n = 0; n < N; n++) {
			bread = Integer.parseInt(st.nextToken());
			if(bread % 10 == 0) arrY.add(bread);
			else arrN.add(bread);
		}
		
		
		int cnt = 0;
		Collections.sort(arrY);
		for(int b : arrY) {
			bread = b / 10;
			if(bread - 1 <= M) {
				cnt += bread;
				M -= bread - 1;
			}
			else {
				cnt += M;
				M = 0;
				break;
			}
		}
		
		if(M > 0) {
			Collections.sort(arrN);
			for(int b : arrN) {
				bread = b / 10;
				if(bread <= M) {
					cnt += bread;
					M -= bread;
				}
				else {
					cnt += M;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}
