import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ9466 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[num+1];
			for(int n = 1; n <= num; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			int[] group = new int[num+1];
			for(int n = 1; n <= num; n++) {
				int cur = n;
				Stack<Integer> stk = new Stack<>();
				while(group[cur] == 0) {
					group[cur] = n;
					stk.push(cur);
					cur = arr[cur];
				}
				if(group[cur] == n) {
					while(true) {
						if(stk.pop() == cur) {
							break;
						}
					}
				}
				cnt += stk.size();
			}
			System.out.println(cnt);
		}
	}
}
