import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ12947 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> cnt1 = new Stack<>();
		cnt1.push(0);
		int[] branchLengs = new int[N+1];
		for(int lv = 1; lv < N; lv++) {
			if(Integer.parseInt(st.nextToken()) == 1) {
				branchLengs[cnt1.peek()] = lv - cnt1.peek() - 1;
				cnt1.push(lv);
			}
		}
		if(Integer.parseInt(st.nextToken()) == 1) {
			branchLengs[cnt1.peek()] = N - cnt1.peek() - 1;
		} else {
			branchLengs[cnt1.peek()] = N - cnt1.peek();
		}
		int cur, maxValue = 0;
		while(!cnt1.isEmpty()) {
			cur = cnt1.pop();
			maxValue = Math.max(maxValue, branchLengs[cur] + N - cur);
		}
		System.out.println(maxValue);
	}
}
// 1 or 다수 만 의미가 있음
// 1인 경우 해당 level 리스트에 기록 (리스트명 : cnt1)
// 1인 경우 : 내 바로 직전에 1이었던 level에서 갈라진 가지는 현재 길이보다 - 1
// 최종 cnt에 다다르면 최종 cnt가 1인 경우 앞전 1에 현재 길이 - 1, 1이 아니면 앞전 1에 현재 길이
// 리프에서 앞전 1까지의 거리 + 앞전 1에 기록된 수 = 으로 찾으며 최대값 확인