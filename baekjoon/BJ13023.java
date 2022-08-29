import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ13023 {
	private static int N;
	private static List<Integer>[] arr;
	private static boolean[] vis;
	
	private static boolean dfs(int prev, int depth) {
		if(depth == 5) {
			return true;
		}
		for(int b : arr[prev]) {
			if(vis[b]) continue;
			vis[b] = true;
			if(dfs(b, depth+1)) return true;
			vis[b] = false;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N];
		for(int n = 0; n < N; n++) {
			arr[n] = new ArrayList<Integer>();
		}
		vis = new boolean[N];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);		
		}
		
		for(int n = 0; n < N; n++) {
			vis[n] = true;
			if(dfs(n, 1)) {
				System.out.println(1);
				return;
			}
			vis[n] = false;
		}
		System.out.println(0);
	}
}

//연결 관계 전부 리스트 기록
//dfs 탐색하며 연결한 사람은 vis 배열에서 true로 변경
//depth가 5가 되면 return true
