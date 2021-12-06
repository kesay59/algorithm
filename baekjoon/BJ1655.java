import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minPq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		StringBuilder stb = new StringBuilder();
		PriorityQueue<Integer> maxPq = new PriorityQueue<Integer>();
		minPq.offer(Integer.parseInt(br.readLine()));
		stb.append(minPq.peek()).append('\n');
		int cur;
		for(int i = 1; i < num; i++) {
			cur = Integer.parseInt(br.readLine());
			if(cur > minPq.peek()) maxPq.offer(cur);
			else minPq.offer(cur);
			if(minPq.size() < maxPq.size()) minPq.offer(maxPq.poll());
			else if(minPq.size() > maxPq.size() + 1) maxPq.offer(minPq.poll());
			stb.append(minPq.peek()).append('\n');
		}
		System.out.println(stb);
	}
}
