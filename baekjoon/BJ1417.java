import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ1417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num == 1) {
			System.out.println(0);
			return;
		}
		int std = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> candidate = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(int i = 1; i < num; i++) {
			candidate.offer(Integer.parseInt(br.readLine()));
		}
		int cnt = 0;
		while(true) {
			int cur = candidate.poll();
			if(std > cur) break;
			std++;
			cnt++;
			candidate.offer(cur-1);
		}
		System.out.println(cnt);
	}
}
