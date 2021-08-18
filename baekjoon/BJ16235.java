import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class BJ16235 {

	private static class Tree implements Comparable<Tree> {
		int age;
		int r, c;

		Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree t) {
			return this.age - t.age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		int len = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());
		PriorityQueue<Tree> map = new PriorityQueue<>();
		int[][] food = new int[len][len];
		int[][] arr = new int[len][len];
		for (int i = 0; i < len; i++) {
			Arrays.fill(food[i], 5);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			map.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}

		Queue<Tree> summer = new LinkedList<>();
		PriorityQueue<Tree> tmp = new PriorityQueue<>();
		PriorityQueue<Tree> swap;
		for (int y = 0; y < year; y++) {
			//spring
			while (!map.isEmpty()) {
				Tree cur = map.poll();
				if (food[cur.r][cur.c] < cur.age) {
					summer.add(cur);
				} else {
					food[cur.r][cur.c] -= cur.age;
					cur.age++;
					tmp.add(cur);
				}
			}
			swap = map;
			map = tmp;
			tmp = swap;
			//summer
			while (!summer.isEmpty()) {
				Tree cur = summer.poll();
				food[cur.r][cur.c] += cur.age / 2;
			}
			//fall
			tmp = new PriorityQueue<>();
			while (!map.isEmpty()) {
				Tree cur = map.poll();
				if (cur.age % 5 == 0) {
					for (int k = 0; k < 8; k++) {
						int r = cur.r + dr[k];
						int c = cur.c + dc[k];
						if (r < 0 || c < 0 || r >= len || c >= len) continue;
						tmp.add(new Tree(r, c, 1));
					}
				}
				tmp.add(cur);
			}
			swap = map;
			map = tmp;
			tmp = swap;
			//winter
			for(int i = 0; i < len; i++)
				for(int j = 0; j < len; j++)
					food[i][j] += arr[i][j];
		}
		System.out.println(map.size());
	}
}
