import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1006 {
	private static int N;
	private static int W;
	
	private static class Area {
		int num;
		int[] neighborhood = new int[3];
		public Area(int num) {
			this.num = num;
			neighborhood[0] = num - 1;
			if(num == 1  || num == N+1) neighborhood[0] += N;
			neighborhood[1] = num + 1;
			if(num == N || num == N*2) neighborhood[1] -= N;
			if(num <= N) neighborhood[2] = num + N;
			else neighborhood[2] = num - N;
			if(neighborhood[1] == neighborhood[0]) neighborhood[1] = -1;
			if(neighborhood[2] == neighborhood[1] || neighborhood[2] == neighborhood[0]) neighborhood[2] = -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			int[] map = new int[N*2 + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = N+1; i <= N*2; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] check = new boolean[N*2 + 1];
			Queue<Area> que = new LinkedList<Area>();
			for(int i = 1; i <= N*2; i++) {
				que.offer(new Area(i));
			}
			int checkCnt = 0, inpCnt = 0;
			Area cur;
			int cnt, staCnt;
			while(checkCnt < N*2) {
				staCnt = checkCnt;
				// 0, 1
				que.offer(new Area(0));
				while(true) {
					cur = que.poll();
					if(cur.num == 0) break;
					if(check[cur.num]) continue;
					
					cnt = 0;
					for(int b = 0; b < 3; b++) {
						if(cur.neighborhood[b] == -1) continue;
						if(!check[cur.neighborhood[b]] && map[cur.num] + map[cur.neighborhood[b]] <= W) cnt++;
					}
					
					if(cnt == 0) {
						check[cur.num] = true;
						checkCnt++;
						inpCnt++;
					} else if(cnt == 1) {
						check[cur.num] = true;
						for(int b = 0; b < 3; b++) {
							if(cur.neighborhood[b] == -1) continue;		
							if(!check[cur.neighborhood[b]] && map[cur.num] + map[cur.neighborhood[b]] <= W) {
								check[cur.neighborhood[b]] = true;
								break;
							}
						}
						checkCnt += 2;
						inpCnt++;
					} else {
						que.offer(cur);
					}
				}
				// 2
				if(staCnt == checkCnt) {
					int stNum = que.peek().num;
					while(true) {
						cur = que.poll();
						if(cur.num == stNum) {
							que.offer(cur);
							break;
						}
						if(check[cur.num]) continue;
						
						cnt = 0;
						for(int b = 0; b < 3; b++) {	
							if(cur.neighborhood[b] == -1) continue;					
							if(!check[cur.neighborhood[b]] && map[cur.num] + map[cur.neighborhood[b]] <= W) cnt++;
						}
						if(cnt == 2) {
							check[cur.num] = true;
							for(int b = 0; b < 3; b++) {
								if(cur.neighborhood[b] == -1) continue;		
								if(!check[cur.neighborhood[b]] && map[cur.num] + map[cur.neighborhood[b]] <= W) {
									check[cur.neighborhood[b]] = true;
									break;
								}
							}
							checkCnt += 2;
							inpCnt++;
							break;
						}
					}
				}
				// 3
				if(staCnt == checkCnt) {
					cur = que.poll();
					check[cur.num] = true;
					check[cur.neighborhood[0]] = true;
					checkCnt += 2;
					inpCnt++;
				}
			}
			System.out.println(inpCnt);
		}
	}
}