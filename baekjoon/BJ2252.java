import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ2252 {
	private static int[] frontCnt; 
	private static Set<Integer>[] backList; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		backList = new HashSet[N+1];
		for(int n = 1; n <= N; n++) {
			backList[n] = new HashSet<>();
		}
		
		int a, b;
		frontCnt = new int[N+1];
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(backList[a].add(b)) frontCnt[b]++;
		}

		Queue<Integer> que = new LinkedList<Integer>();
		for(int n = 1; n <= N; n++) {
			if(frontCnt[n] == 0) que.offer(n);
		}
		
		StringBuilder stb = new StringBuilder();
		Integer cur;
		while(!que.isEmpty()) {
			cur = que.poll();
			stb.append(cur).append(' ');
			for(int no : backList[cur]) {
				if(--frontCnt[no] == 0) que.offer(no);
			}
		}
		System.out.println(stb.toString());
	}
}