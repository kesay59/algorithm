import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ12018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int mileage = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int n = 0; n < num; n++) {
			st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken());
			int lim = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			if(lim > people) {
				pq.offer(1);
			} else {
				int[] mileageArr = new int[people];
				for(int i = 0; i < people; i++) {
					mileageArr[i] = Integer.parseInt(st.nextToken());
				}
				Arrays.sort(mileageArr);
				pq.offer(mileageArr[people - lim]);
			}
		}
		int cnt = 0;
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			if(mileage >= cur) {
				mileage -= cur;
				cnt++;
			} else {
				break;
			}
		}
		System.out.println(cnt);
	}
}
