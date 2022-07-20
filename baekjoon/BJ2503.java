import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2503 {
	private static int checkBall(int[] answer, int[] question) {
		int cnt = 0;
		if(answer[0] == question[1]) cnt++;
		else if(answer[0] == question[2]) cnt++;
		if(answer[1] == question[0]) cnt++;
		else if(answer[1] == question[2]) cnt++;
		if(answer[2] == question[0]) cnt++;
		else if(answer[2] == question[1]) cnt++;
		return cnt;
	}
	private static int checkStrike(int[] answer, int[] question) {
		int cnt = 0;
		for(int i = 0; i < 3; i++) {
			if(answer[i] == question[i]) cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		Queue<int[]> que = new LinkedList<int[]>();
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				if(i == j) continue;
				for(int k = 1; k < 10; k++) {
					if(i == k || j == k) continue;
					que.offer(new int[] {i, j, k});
				}
			}
		}
		que.offer(new int[] {0, 0, 0});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String questionStr;
		int[] question;
		int ball, strike;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			questionStr = st.nextToken();
			question = new int[] {questionStr.charAt(0) - '0', questionStr.charAt(1) - '0', questionStr.charAt(2) - '0'};
			strike = Integer.parseInt(st.nextToken());
			ball = Integer.parseInt(st.nextToken());
			int[] cur;
			while(true) {
				cur = que.poll();
				if(cur[0] == 0) {
					que.offer(cur);
					break;
				}
				if(checkStrike(cur, question) != strike) continue;
				if(checkBall(cur, question) != ball) continue;
				que.offer(cur);
			}
		}
		System.out.println(que.size() - 1);
	}
}
