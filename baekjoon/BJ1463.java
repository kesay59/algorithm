import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 1463 1로 만들기
public class BJ1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[num];
		Queue<Integer> que = new LinkedList<Integer>();
		int cur = num;
		int cnt = 0;
		while(cur != 1) {
			if(cur > 1) {
				if(!arr[cur - 1]) {
					arr[cur - 1] = true;
					que.add(cur - 1);
					que.add(cnt);
				}
				if(cur % 2 == 0) {
					if(!arr[cur / 2]) {
						arr[cur / 2] = true;
						que.add(cur / 2);
						que.add(cnt);
					}
				}
				if(cur % 3 == 0) {
					if(!arr[cur / 3]) {
						arr[cur / 3] = true;
						que.add(cur / 3);
						que.add(cnt);
					}
				}
			}
			cur = que.poll();
			cnt = que.poll() + 1;
		}
		System.out.println(cnt);
	}

}
