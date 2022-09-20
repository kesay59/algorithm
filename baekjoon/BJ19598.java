import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ19598 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> sta = new PriorityQueue<Integer>();
		PriorityQueue<Integer> end = new PriorityQueue<Integer>();
		StringTokenizer st;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			sta.offer(Integer.parseInt(st.nextToken()));
			end.offer(Integer.parseInt(st.nextToken()));
		}
		int maxValue = 0, value = 0;
		while(!sta.isEmpty()) {
			if(sta.peek() < end.peek()) {
				sta.poll();
				value++;
				maxValue = Math.max(maxValue, value);
			} else {
				end.poll();
				value--;
			}
		}
		System.out.println(maxValue);
	}
}
