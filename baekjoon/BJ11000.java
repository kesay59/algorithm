import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());;
		int[] start = new int[num];
		int[] end = new int[num];
		StringTokenizer st;
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			start[i] = Integer.parseInt(st.nextToken());
			end[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int cnt = 0, max = 0;
		int curS = 0, curE = 0;
		for(; curS < num; curS++) {
			cnt++;
			while(curE < num && end[curE] <= start[curS]) {
				cnt--;
				curE++;
			}
			if(max < cnt) max = cnt;
		}
		System.out.println(max);
	}
}
