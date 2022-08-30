import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ20057 {
	private static int[] dr = new int[] {0, 1, 0, -1};
	private static int[] dc = new int[] {-1, 0, 1, 0};
	private static int[][] arr;
	private static boolean[][] vis;
	private static int answer = 0;
	
	private static void move(int prevR, int prevC, int dir) {
		if(prevR == 0 && prevC == 0) return;
		int nextR = prevR + dr[dir], nextC = prevC + dc[dir];
		int front = dir, left = (dir + 1) % 4, right = (dir + 3) % 4;
		int sand = arr[nextR][nextC], sum = 0;
		int tmp, targetR, targetC;
		
		tmp = sand * 1 / 100;
		sum += tmp * 2;
		targetR = prevR + dr[right];
		targetC = prevC + dc[right];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		targetR = prevR + dr[left];
		targetC = prevC + dc[left];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;

		tmp = sand * 7 / 100;
		sum += tmp * 2;
		targetR = nextR + dr[right];
		targetC = nextC + dc[right];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		targetR = nextR + dr[left];
		targetC = nextC + dc[left];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		
		tmp = sand * 2 / 100;
		sum += tmp * 2;
		targetR = nextR + dr[right] + dr[right];
		targetC = nextC + dc[right] + dc[right];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		targetR = nextR + dr[left] + dr[left];
		targetC = nextC + dc[left] + dc[left];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		
		tmp = sand * 10 / 100;
		sum += tmp * 2;
		targetR = nextR + dr[front] + dr[right];
		targetC = nextC + dc[front] + dc[right];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		targetR = nextR + dr[front] + dr[left];
		targetC = nextC + dc[front] + dc[left];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		
		tmp = sand * 5 / 100;
		sum += tmp;
		targetR = nextR + dr[front] + dr[front];
		targetC = nextC + dc[front] + dc[front];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		
		tmp = sand - sum;
		targetR = nextR + dr[front];
		targetC = nextC + dc[front];
		if(targetR < 0 || targetR >= arr.length || targetC < 0 || targetC >= arr.length) answer += tmp;
		else arr[targetR][targetC] += tmp;
		
		vis[nextR][nextC] = true;
		if(!vis[nextR + dr[(dir + 1) % 4]][nextC + dc[(dir + 1) % 4]]) dir = (dir + 1) % 4;
		move(nextR, nextC, dir);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		vis = new boolean[N][N];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		vis[N/2][N/2] = true;
		move(N/2, N/2, 0);
		System.out.println(answer);
	}
}