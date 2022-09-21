import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ17140 {
	private static int R = 3, C = 3;
	private static int targetR, targetC, k;
	private static int[][] arr = new int[100][100];
	private static Comparator<int[]> comparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[1] == o2[1]) return o1[0] - o2[0];
			return o1[1] - o2[1];
		}
	};
	private static PriorityQueue<int[]> sort(HashMap<Integer, Integer> hm) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(comparator);
		for(Map.Entry<Integer, Integer> e : hm.entrySet()) {			
			pq.offer(new int[] {e.getKey(), e.getValue()});
		}
		return pq;
	}
	private static void calcC() {
		for(int c = 0; c < C; c++) {
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			for(int r = 0; r < R; r++) {
				if(arr[r][c] == 0) continue;
				if(hm.containsKey(arr[r][c])) hm.put(arr[r][c], hm.get(arr[r][c]) + 1);
				else hm.put(arr[r][c], 1);
			}
			PriorityQueue<int[]> pq = sort(hm);
			R = Math.min(100, Math.max(R, pq.size() * 2));
			int[] cur;
			for(int r = 0; r < R; r++) {
				if(!pq.isEmpty()) {					
					cur = pq.poll();
					arr[2*r][c] = cur[0];
					arr[2*r+1][c] = cur[1];
				} else {
					arr[2*r][c] = 0;
					arr[2*r+1][c] = 0;
				}
			}
		}
	}
	private static void calcR() {
		for(int r = 0; r < R; r++) {
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			for(int c = 0; c < C; c++) {
				if(arr[r][c] == 0) continue;
				if(hm.containsKey(arr[r][c])) hm.put(arr[r][c], hm.get(arr[r][c]) + 1);
				else hm.put(arr[r][c], 1);
			}
			PriorityQueue<int[]> pq = sort(hm);
			C = Math.min(100, Math.max(C, pq.size() * 2));
			int[] cur;
			for(int c = 0; c < C; c++) {
				if(!pq.isEmpty()) {					
					cur = pq.poll();
					arr[r][2*c] = cur[0];
					arr[r][2*c+1] = cur[1];
				} else {
					arr[r][2*c] = 0;
					arr[r][2*c+1] = 0;
				}
			}
		}
	}
	private static boolean check() {
		if(arr[targetR][targetC] == k) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		targetR = Integer.parseInt(st.nextToken()) - 1;
		targetC = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(check()) {
			System.out.println(0);
			return;
		}
		for(int t = 1; t <= 100; t++) {
			if(R >= C) calcR();
			else calcC();
			if(check()) {
				System.out.println(t);
				return;
			}
		}
		System.out.println(-1);
	}
}
