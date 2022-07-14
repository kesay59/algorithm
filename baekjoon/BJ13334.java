import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//사무실 기준 정렬
//철로 뒤가 사무실 넘으면 cnt + 1 하고 집을 pq에 넣음
//철로 앞이 집 아래면 cnt - 1 하면서 pq 뽑기
//철로 뒤를 다음 사무실 위치로 이동
//반복하면서 maxCnt 기록
public class BJ13334 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lines = new int[N][2];
		StringTokenizer st;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			lines[n][0] = Integer.parseInt(st.nextToken());
			lines[n][1] = Integer.parseInt(st.nextToken());
			if(lines[n][0] > lines[n][1]) {
				int tmp = lines[n][0];
				lines[n][0] = lines[n][1];
				lines[n][1] = tmp;
			}
		}
		Arrays.sort(lines, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int leng = Integer.parseInt(br.readLine());
		int sta, end, cnt = 0, maxCnt = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int n = 0; n < N; n++) {
			end = lines[n][1];
			sta = end - leng;
			cnt++;
			pq.offer(lines[n][0]);
			while(!pq.isEmpty()) {
				if(pq.peek() < sta) {
					cnt--;
					pq.poll();
				} else {
					break;
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}
}
