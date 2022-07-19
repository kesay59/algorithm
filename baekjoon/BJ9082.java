import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9082 {
	private static int len;
	private static char[][] map = new char[2][];
	private static boolean dfs(int idx) {
		if(idx == len) {
			if((idx >= 2 && map[0][idx - 2] != '0') || (idx >= 1 && map[0][idx-1] != '0')) return false;
			int cnt = 0;
			for(int i = 0; i < len; i++) {
				if(map[1][i] == '*') cnt++;
			}
			System.out.println(cnt);
			return true;
		}
		if(idx >= 2 && map[0][idx - 2] != '0') {
			return false;
		}
		if(map[1][idx] == '*') {
			if(idx >= 1) map[0][idx - 1]--;
			map[0][idx]--;
			if(idx < len - 1) map[0][idx + 1]--;
			return dfs(idx + 1);
		}
		else {
			if((idx < 1 || map[0][idx - 1] > '0') && (idx + 1 == len || map[0][idx + 1] > '0') && map[0][idx] > '0') {
				if(idx >= 1) map[0][idx - 1]--;
				map[0][idx]--;
				if(idx < len - 1) map[0][idx + 1]--;
				map[1][idx] = '*';
				if(dfs(idx + 1)) return true;				
				map[1][idx] = '#';
				if(idx < len - 1) map[0][idx + 1]--;
				map[0][idx]--;
				if(idx >= 1) map[0][idx - 1]--;
			}
			return dfs(idx + 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			len = Integer.parseInt(br.readLine());
			map[0] = br.readLine().toCharArray();
			map[1] = br.readLine().toCharArray();
			dfs(0);
		}
	}
}
