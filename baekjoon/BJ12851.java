import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ12851 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N > K) {
			System.out.println(N - K);
			System.out.println(1);
			return;
		}
		
		Set<Integer>[] locs = new HashSet[2];
		locs[0] = new HashSet<>();
		locs[1] = new HashSet<>();
		int flag = 0;
		
		int[][] arr = new int[2][100001];
		boolean[] vis = new boolean[100001];
		int cnt = 0;	
		locs[flag].add(N);
		arr[flag][N] = 1;
		
		while(true) {
			if(arr[flag][K] > 0) {
				System.out.println(cnt);
				System.out.println(arr[flag][K]);
				break;
			} 
			for(Integer cur : locs[flag]) {
				vis[cur] = true;
				if(cur + 1 <= 100000 && !vis[cur + 1]) {
					locs[flag^1].add(cur + 1);
					arr[flag^1][cur + 1] += arr[flag][cur];
				}
				if(cur - 1 >= 0 && !vis[cur - 1]) {
					locs[flag^1].add(cur - 1);
					arr[flag^1][cur - 1] += arr[flag][cur];
				}
				if(cur * 2 <= 100000 && !vis[cur * 2]) {
					locs[flag^1].add(cur * 2);
					arr[flag^1][cur * 2] += arr[flag][cur];				
				}
			}
			locs[flag] = new HashSet<Integer>();
			arr[flag] = new int[100001];
			cnt++;
			flag ^= 1;
		} 
	}
}
