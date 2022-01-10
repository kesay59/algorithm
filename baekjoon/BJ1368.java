import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1368 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] water = new int[N];
		for(int i = 0; i < N; i++) {
			water[i] = Integer.parseInt(br.readLine());
		}
		int[][] cost = new int[N][N];
		StringTokenizer st;
		int min;
		boolean[] check = new boolean[N];
		boolean[][] best = new boolean[N][N];
		int answer = 0;
		Queue<Integer> checkedIdx = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			min = water[i];
			for(int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				if(i != j && cost[i][j] < min) min = cost[i][j];
			}
			if(min == water[i]) {
				check[i] = true;
				answer += water[i];
				checkedIdx.offer(i);
			}
			else {
				for(int j = 0; j < N; j++) {
					if(cost[i][j] == min) best[i][j] = true;
				}
			}
		}
		while(true) {
			boolean checkAll = true;
			for(int i = 0; i < N; i++) {
				if(!check[i]) {
					checkAll = false;
					break;
				}
			}
			if(checkAll) break;
			int cur;
			while(!checkedIdx.isEmpty()) {
				cur = checkedIdx.poll();
				for(int i = 0; i < N; i++) {
					if(!check[i] && best[i][cur]) {
						check[i] = true;
						answer += cost[i][cur];
						checkedIdx.offer(i);
					}
				}
			}
			int idx = -1;
			min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				if(!check[i]) {
					if(idx == -1) {
						min = water[i];
						for(int k = 0; k < N; k++) {
							if(i == k) continue;
							if(check[k] && cost[i][k] < min) min = cost[i][k];
						}
						idx = i;
					}
					else {
						if(min > water[i]) {
							min = water[i];
							idx = i;
						}
						for(int k = 0; k < N; k++) {
							if(i == k) continue;
							if(check[k] && cost[i][k] < min) {
								min = cost[i][k];
								idx = i;
							}
						}
					}
				}
			}
			if(idx == -1) break;
			check[idx] = true;
			answer += min;
			checkedIdx.offer(idx);
		}
		System.out.println(answer);
	}
}
