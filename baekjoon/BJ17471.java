package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 17471 게리맨더링
public class BJ17471 {

	static int len;
	static boolean[][] arr;
	static int[] popluation;
	static int min =Integer.MAX_VALUE;
	
	static boolean isConnected(int sel) {
		if(sel == 0) return false;
		Queue<Integer> que= new LinkedList<>();
		int vis = 0;
		for(int i = 0; i < len; i++)
			if((sel & (1 << i)) != 0) {
				que.add(i);
				break;
			}
		while(!que.isEmpty()) {
			int cur = que.poll();
			if((vis & (1 << cur)) != 0) continue;
			vis |= (1 << cur);
			for(int i = 0; i < len; i++)
				if(arr[cur][i] && ((sel & (1 << i)) != 0)) que.add(i);
		}
		
		if(vis == sel ) return true;
		return false;
	}
	
	static void select(int idx, int selA, int selB) {
		if(idx == len) {
			if(isConnected(selA) && isConnected(selB)) {
				int sum = 0;
				for(int i = 0; i < len; i++) {
					if((selA & (1 << i)) != 0) sum += popluation[i];
					else sum -= popluation[i];
				}
				min = Math.min(min, Math.abs(sum));
			}
			return;
		}
		int tmpA = (selA | (1 << idx));
		int tmpB = (selB | (1 << idx));
		select(idx + 1, tmpA, selB);
		select(idx + 1, selA, tmpB);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		arr = new boolean[len][len];
		popluation = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < len; i++)
			popluation[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens())
				arr[i][Integer.parseInt(st.nextToken()) - 1] = true;
		}
		select(0, 0, 0);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
}
