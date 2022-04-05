import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ9019 {
	private static int calcD(int n) {
		return n*2%10000;
	}
	private static int calcS(int n) {
		return n == 0 ? 9999 : n-1;
	}
	private static int calcL(int n) {
		String strN = Integer.toString(n);
		if(strN.length() < 4) strN = new String(new char[4 - strN.length()]).replace("\0", "0") + strN;
		return Integer.parseInt(strN.substring(1) + strN.charAt(0));
	}
	private static int calcR(int n) {
		String strN = Integer.toString(n);
		if(strN.length() < 4) strN = new String(new char[4 - strN.length()]).replace("\0", "0") + strN;
		return Integer.parseInt(strN.charAt(3) + strN.substring(0, 3));
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int origin = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			boolean[] vis = new boolean[10001];
			Queue<Object[]> que = new LinkedList<Object[]>();
			que.add(new Object[] {origin, ""});
			while(!que.isEmpty()) {
				Object[] cur = que.poll();
				int n = calcD((int) cur[0]);
				if(n == target) {
					System.out.println((String) cur[1] + 'D');
					break;
				} else {
					if(!vis[n]) {
						vis[n] = true;
						que.offer(new Object[] {n, (String) cur[1] + 'D'});
					}
				}
				n = calcS((int) cur[0]);
				if(n == target) {
					System.out.println((String) cur[1] + 'S');
					break;
				} else {
					if(!vis[n]) {
						vis[n] = true;
						que.offer(new Object[] {n, (String) cur[1] + 'S'});
					}
				}
				n = calcL((int) cur[0]);
				if(n == target) {
					System.out.println((String) cur[1] + 'L');
					break;
				} else {					
					if(!vis[n]) {
						vis[n] = true;
						que.offer(new Object[] {n, (String) cur[1] + 'L'});
					}
				}
				n = calcR((int) cur[0]);
				if(n == target) {
					System.out.println((String) cur[1] + 'R');
					break;
				} else {					
					if(!vis[n]) {
						vis[n] = true;
						que.offer(new Object[] {n, (String) cur[1] + 'R'});
					}
				}
			}
		}
	}
}
