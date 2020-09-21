import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2564 경비원
public class BJ2564 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(br.readLine());
		len += len;
		int sum = 0;
		int[] arr = new int[len];
		for(int i = 0; i < len; ) {
			st = new StringTokenizer(br.readLine());
			arr[i++] = Integer.parseInt(st.nextToken()) - 1;
			arr[i++] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken()) - 1;
		int loc = Integer.parseInt(st.nextToken());
		for(int i = 0; i < len; i++) {
			if(dir == arr[i]) {
				sum += Math.abs(loc - arr[++i]);
			} else if(dir / 2 == arr[i] / 2) {
				if(dir / 2 == 0) {
					sum += Math.min(loc + arr[++i], col - loc + col - arr[i]);
					sum += row;
				} else {
					sum += Math.min(loc + arr[++i], row - loc + row - arr[i]);
					sum += col;
				}
			} else if(dir % 2 == arr[i] % 2) {
				if(dir % 2 == 0) {
					sum += loc + arr[++i];
				}else {
					sum += col + row - loc - arr[++i];
				}
			} else {
				if(dir == 0) {
					sum += col - loc + arr[++i];
				} else if(dir == 2) {
					sum += row - loc + arr[++i];
				} else if(dir == 1) {
					sum += loc + row - arr[++i];					
				} else {
					sum += loc + col - arr[++i];
				}
			}
		}
		System.out.println(sum);
	}
}
