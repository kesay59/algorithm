import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ21773 {
	private static class Pc implements Comparable<Pc>{
		int id;
		int rmTime;
		int priority;
		
		public Pc(int id, int rmTime, int priority) {
			this.id = id;
			this.rmTime = rmTime;
			this.priority = priority;
		}
		
		@Override
		public int compareTo(Pc o) {
			if(this.priority == o.priority) return this.id - o.id;
			return o.priority - this.priority;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		PriorityQueue<Pc> pq = new PriorityQueue<Pc>();
		for(int c = 0; c < cnt; c++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Pc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		StringBuilder stb = new StringBuilder();
		Pc cur;
		for(int n = 0; n < num; n++) {
			while(!pq.isEmpty()) {
				cur = pq.poll();
				if(cur.rmTime > 0) {
					stb.append(cur.id).append('\n');
					cur.priority--;
					cur.rmTime--;
					pq.offer(cur);
					break;
				}
			}
			if(pq.isEmpty()) break;
		}
		System.out.println(stb);
	}
}
