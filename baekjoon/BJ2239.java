import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2239 {

	private static class Node implements Comparable<Node> {
		int r, c;
		char val;

		public Node(int r, int c, char val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

		public int compareTo(Node n) {
			if (this.r == n.r)
				return this.c - n.c;
			return this.r - n.r;
		}
	}

	private static char[][] map;

	private static boolean fail(int r, int c, char val) {
		for (int k = 0; k < 9; k++) {
			if (map[r][k] == val)
				return false;
			if (map[k][c] == val)
				return false;
		}
		int i = r / 3 * 3;
		int j = c / 3 * 3;
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				if (map[i + a][j + b] == val)
					return false;
			}
		}
		return true;
	}

	private static void dfs(int i, int j) {
		for (; i < 9; i++) {
			for (; j < 9; j++) {
				if (map[i][j] == 48) {
					for (char ch = 49; ch < 58; ch++) {
						if (fail(i, j, ch)) {
							map[i][j] = ch;
							dfs(i, j);
							map[i][j] = 48;
						}
					}
					if (map[i][j] == 48) return;
				}
			}
			j = 0;
		}
		for (int k = 0; k < 9; k++) {
			for (char ch : map[k])
				System.out.print(ch);
			System.out.println();
		}
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[9][];
		for (int i = 0; i < 9; i++)
			map[i] = br.readLine().toCharArray();

		dfs(0, 0);
	}

}

//PriorityQueue<Node> pq = new PriorityQueue<>();
//start : while(true) {			
//	while(!pq.isEmpty()) {
//		Node cur = pq.poll();
//		map[cur.r][cur.c] = cur.val;
//		boolean[] check = new boolean[10];
//		int k = 0;
//		Node tmp = null;
//		for(; k < 9; k++) {
//			if(check[0]) break;
//			check[map[k][cur.c] - 48] = true;
//			if(map[k][cur.c] == 48) tmp = new Node(k, cur.c);
//		}
//		if(k == 9 && tmp != null) {
//			for(char i = 1; i < 9; i++)
//				if(!check[i]) tmp.val = (char)(i + 48);
//		}
//		
//		check = new boolean[10];
//		k = 0;
//		tmp = null;
//		for(; k < 9; k++) {
//			if(check[0]) break;
//			check[map[cur.r][k] - 48] = true;
//			if(map[cur.r][k] == 48) tmp = new Node(cur.r, k);
//		}
//		if(k == 9 && tmp != null) {
//			for(char i = 1; i < 9; i++)
//				if(!check[i]) tmp.val = (char)(i + 48);
//		}
//		
//		check = new boolean[10];
//		tmp = null;
//		boolean flag = true;
//		int i = (int) (cur.r / 3) * 3;
//		int j = (int) (cur.c / 3) * 3;
//		for(int a = 0; a < 3; a++) {
//			for(int b = 0 ; b < 3; b++) {
//				if(check[0]) {
//					flag = false;
//					break;
//				}
//				check[map[i + a][j + b] - 48] = true;
//				if(map[i + a][j + b] == 48) tmp = new Node(i+a, j+b);
//			}
//		}
//		if(flag && tmp != null) {
//			for(char ch = 1; ch < 9; ch++)
//				if(!check[ch]) tmp.val = (char)(ch + 48);
//		}
//	}
//	for(int i = 0; i < 9; i++) {
//		for(int j = 0; j < 9; j++) {
//			if(map[i][j] == 48) {
//				for(char val = 49; val < 58; val++) {
//					if(fail(i, j, val)) {
//						pq.add(new Node(i, j, val));
//						continue start;
//					}
//				}
//			}
//		}
//	}
//	break;
//}