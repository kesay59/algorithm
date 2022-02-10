import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] upArr = new int[H + 1];
		int[] downArr = new int[H + 1];
		for(int n = 0; n < N; n++) {
			if(n%2==0) {
				downArr[Integer.parseInt(br.readLine())]++;
			} else {
				upArr[Integer.parseInt(br.readLine())]++;
			}
		}
		int tmp;
		upArr[0] = N / 2;
		for(int h = 1; h <= H; h++) {
			tmp = upArr[0] - upArr[h];
			upArr[h] = upArr[0];
			upArr[0] = tmp;
		}
		downArr[0] = (N+1)/2;
		for(int h = 1; h <= H; h++) {
			tmp = downArr[0] - downArr[h];
			downArr[h] = downArr[0];
			downArr[0] = tmp;
		}
		int[] cave = new int[H];
		for(int h = 0; h < H; h++) {
			cave[h] = upArr[h+1] + downArr[H - h];
		}
		int min = Integer.MAX_VALUE;
		for(int num : cave) {
			min = Math.min(min, num);
		}
		int cnt = 0;
		for(int num : cave) {
			if(min == num) cnt++;
		}
		System.out.println(min + " " + cnt);
	}
}
