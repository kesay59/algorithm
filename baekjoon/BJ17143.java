import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17143 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sharks = new int[M+1][];
		int r, c, s, d, z;
		int rLen = R * 2 - 2;
		int cLen = C * 2 - 2;
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			if(d <= 2) s %= rLen;
			else s %= cLen;
			sharks[m] = new int[] {m, r, c, s, d, z, 1};
		}

		int[][][] map = new int[2][R+1][C+1];
		int flag = 0;
		Queue<int[]> sharkQue = new LinkedList<int[]>();
		for(int m = 1; m <= M; m++) {
			map[flag][sharks[m][1]][sharks[m][2]] = sharks[m][0];
			sharkQue.offer(sharks[m]);
		}
		sharkQue.offer(new int[] {0, 0, 0, 0, 0, 0, 0});
		
		int sum = 0;
		for(int j = 1; j <= C; j++) {
			for(int i = 1; i <= R; i++) {
				if(map[flag][i][j] != 0) {
					sum += sharks[map[flag][i][j]][5];
					sharks[map[flag][i][j]][6] = 0;
					map[flag][i][j] = 0;
					break;
				} 
			}
			int[] shark;
			while(true) {
				shark = sharkQue.poll();
				if(shark[0] == 0) {
					sharkQue.offer(shark);
					break;
				}
				if(shark[6] == 0) continue;
				
				map[flag][shark[1]][shark[2]] = 0;
				if(shark[4] == 1) {
					shark[1] -= shark[3];
				} else if(shark[4] == 2) {
					shark[1] += shark[3];
				} else if(shark[4] == 3) {
					shark[2] += shark[3];
				} else {
					shark[2] -= shark[3];
				}
				while(true) {
					if(shark[4] == 1) {
						if(shark[1] < 1) {
							shark[1] = 2 + Math.abs(shark[1]);
							shark[4] = 2;
						} else {
							break;
						}
					} else if(shark[4] == 2) {
						if(shark[1] > R) {
							shark[1] = R * 2 - shark[1];
							shark[4] = 1;
						} else {
							break;
						}
					} else if(shark[4] == 3) {
						if(shark[2] > C) {
							shark[2] = C * 2 - shark[2];
							shark[4] = 4;
						} else {
							break;
						}
					} else {
						if(shark[2] < 1) {
							shark[2] = 2 + Math.abs(shark[2]);
							shark[4] = 3;
						} else {
							break;
						}
					}
				}
				if(map[flag^1][shark[1]][shark[2]] != 0) {
					if(shark[5] > sharks[map[flag^1][shark[1]][shark[2]]][5]) {
						sharks[map[flag^1][shark[1]][shark[2]]][6] = 0;
						map[flag^1][shark[1]][shark[2]] = shark[0];
						sharkQue.offer(shark);
					} else {
						shark[6] = 0;
					}
				} else {
					map[flag^1][shark[1]][shark[2]] = shark[0];
					sharkQue.offer(shark);
				}
			}
			flag ^= 1;
		}
		System.out.println(sum);
	}
}
