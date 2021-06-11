import java.io.*;
import java.util.*;

public class BJ1034 {
	
	private static class Line implements Comparable<Line> {
		int zeroCnt, cnt;
		Line(int zeroCnt, int cnt){
			this.zeroCnt = zeroCnt;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Line o) {
			return o.cnt - this.cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		for(int i = 0; i < row; i++) {
			String key = br.readLine();
			if(count.get(key) == null) count.put(key, 1);
			else count.put(key, count.get(key) + 1);
		}
		
		int k = Integer.parseInt(br.readLine());
		
		PriorityQueue<Line> pq = new PriorityQueue<>();
		Set keys = count.keySet();
		Iterator iterator = keys.iterator();
		while(iterator.hasNext()) {
			String key = (String)iterator.next();
			char[] keyArr = key.toCharArray();
			int zeroCnt = 0;
			for(char ch : keyArr) {
				if(ch == '0') zeroCnt++;
			}
			pq.add(new Line(zeroCnt, count.get(key)));
		}
		
		boolean flag = true;
		while(!pq.isEmpty()) {
			Line cur = pq.poll();
			if(cur.zeroCnt <= k && (k - cur.zeroCnt) % 2 == 0) {
				System.out.println(cur.cnt);
				flag = false;
				break;
			}
		}
		if(flag) System.out.println(0);
	}
}
//행을 키로 사용하고 맵 형태로 개수
//개수가 큰 순서대로 queue에 넣고 pop
//k에서 0의 수를 뺀 후 2로 나눴을 때 나머지가 없으면 성공
