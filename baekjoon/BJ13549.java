import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ13549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] vis = new boolean[100001];
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.offerLast(N);
		dq.offerLast(-1);
		int cnt = 0;
		while(true) {
			int cur = dq.poll();
			if(cur == -1) {
				cnt++;
				dq.offerLast(-1);
				continue;
			}
			if(cur == M) {
				System.out.println(cnt);
				return;
			}
			
			if(vis[cur]) continue;
			vis[cur] = true;
			
			if(cur < M) {
				if(cur * 2 <= 100000) dq.offerFirst(cur * 2);
				if(cur + 1 <= 100000) dq.offerLast(cur + 1);
				if(cur - 1 >= 0) dq.offerLast(cur - 1);  
			} else {
				if(cur - 1 >= 0) dq.offerLast(cur - 1);
			}
		}
	}
}
