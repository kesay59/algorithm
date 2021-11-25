import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hNum = Integer.parseInt(st.nextToken());
		int sNum = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<String>();
		for(int i = 0; i < hNum; i++) {
			hs.add(br.readLine());
		}
		PriorityQueue<String> pq = new PriorityQueue<String>();
		String name;
		for(int i = 0; i < sNum; i++) {
			name = br.readLine();
			if(hs.contains(name)) pq.offer(name);
		}
		StringBuilder stb = new StringBuilder().append(pq.size()).append('\n');
		while(!pq.isEmpty()) {
			stb.append(pq.poll()).append('\n');
		}
		System.out.println(stb);
	}
}
