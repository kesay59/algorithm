import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1058 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[num][num];
		for(int i = 0; i < num; i++) {
			String line = br.readLine();
			for(int j = 0; j < num; j++) {
				arr[i][j] = line.charAt(j) == 'Y';
			}
		}
		int[] cnt = new int[num];
		for(int i = 0; i < num; i++) {
			for(int j = i + 1; j < num; j++) {
				if(arr[i][j]) {
					cnt[i]++;
					cnt[j]++;
				} else {
					for(int k = 0; k < num; k++) {
						if(k == i || k == j) continue;
						if(arr[i][k] && arr[j][k]) {
							cnt[i]++;
							cnt[j]++;
							break;
						}
					}
				}
			}
		}
		int maxCnt = 0;
		for(int c : cnt) {
			maxCnt = Math.max(maxCnt, c);
		}
		System.out.println(maxCnt);
	}
}
