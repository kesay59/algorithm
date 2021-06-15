import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1024 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		for(; L <= 100; L++) {
			double a = N / (double)L - (L - 1) / 2.;
			if(a < 0 && a > -1) a = Math.abs(a);
			if(Math.abs((int)a - a) < 0.0000000001) {
				int start = (int)a;
				if(start < 0) {
					System.out.println(-1);
				}
				else {
					for(int l = 0; l < L; l++) {
						System.out.print(start + l + " ");
					}
				}
				break;
			}
		}
		if(L > 100) System.out.println(-1);
		
//		for(; L <= 100; L++) {
//			if(L % 2 == 0) {
//				if(N % (L / 2) == 0 && (N / (L / 2)) % 2 == 1) {
//					int start = (N / (L / 2) + 1) / 2 - (L / 2);
//					if(start < 0) {
//						System.out.println(-1);
//					}
//					else {
//						for(int l = 0; l < L; l++) {
//							System.out.print(start + l + " ");
//						}
//					}
//					break;
//				}
//			}
//			else {
//				if(N % L == 0) {
//					int start = N / L - (L / 2);
//					if(start < 0) {
//						System.out.println(-1);
//					}
//					else {
//						for(int l = 0; l < L; l++) {
//							System.out.print(start + l + " ");
//						}
//					}
//					break;
//				}
//			}
//		}
//		if(L > 100) System.out.println(-1);
	}
}
//리스트 개수 홀수 : 리스트 개수로 나눠떨어지면 가능
//리스트 개수 짝수 : 리스트 개수 절반으로 나뉘고 나뉜 수가 홀수면 가능


// sum = (n * (2*a + (n-1)*d)) / 2
// 2 * N = L * (2*a + L - 1)
// a = (2 * N / L - L + 1) / 2
// a = N / L - (L - 1) / 2