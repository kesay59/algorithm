import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 0; i < M; i++) {			
			que.offer(Integer.parseInt(st.nextToken()));
		}
		
		int answer = 0;
		boolean[] isOut = new boolean[N + 1];
		int cur = 1, sub, cntUp, cntDown;
		while(!que.isEmpty()) {
			int tg = que.poll();
			
			cntUp = 0;
			sub = cur;
			while(sub != tg) {
				while(true) {
					if(++sub > N) sub -= N;
					if(!isOut[sub]) break;
				}
				cntUp++;
			}
			
			cntDown = 0;
			sub = cur;
			while(sub != tg) {
				while(true) {
					if(--sub < 1) sub += N;
					if(!isOut[sub]) break;					
				}
				cntDown++;
			}
			
			answer += Math.min(cntUp, cntDown);
			isOut[tg] = true;
			cur = tg;
			while(!que.isEmpty()) {
				if(++cur > N) cur -= N;
				if(!isOut[cur]) break;
			}
		}
		System.out.println(answer);
	}
	
}
