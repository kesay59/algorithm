import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9328 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			char[][] map = new char[row][];
			for(int r = 0; r < row; r++) {
				map[r] = br.readLine().toCharArray();
			}
			List<int[]>[] doors = new List[26];
			for(int i = 0; i < 26; i++) {
				doors[i] = new ArrayList<int[]>();
			}
			String keyStr = br.readLine();
			
			List<int[]> entrance = new ArrayList<>();
			for(int r = 0; r < row; r++) {
				if(map[r][0] != '*') entrance.add(new int[] {r, 0});
				if(map[r][col-1] != '*') entrance.add(new int[] {r, col-1});
			}
			for(int c = 1; c < col - 1; c++) {
				if(map[0][c] != '*') entrance.add(new int[] {0, c});
				if(map[row-1][c] != '*') entrance.add(new int[] {row-1, c});
			}
			boolean[] havenKeys = new boolean[26];
			if(!"0".equals(keyStr)) {
				for(char key : keyStr.toCharArray()) {
					havenKeys[key - 'a'] = true;
				}
				for(int r = 0; r < row; r++) {
					for(int c = 0; c < col; c++) {
						if(map[r][c] >= 'a' && map[r][c] <= 'z') {
							if(havenKeys[map[r][c] - 'a']) map[r][c] = '.';
						} else if(map[r][c] >= 'A' && map[r][c] <= 'Z') {
							if(havenKeys[map[r][c] - 'A']) map[r][c] = '.';
						}
					}
				}				
			}
			
			int[] dr = new int[] {-1, 0, 1, 0};
			int[] dc = new int[] {0, -1, 0, 1};
			findKey : while(true) {
				boolean[][] vis = new boolean[row][col];
				Queue<int[]> que = new LinkedList<int[]>();
				for(int[] e : entrance) {
					que.offer(e);
				}
				int cnt = 0;
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					if(vis[cur[0]][cur[1]]) continue;
					vis[cur[0]][cur[1]] = true;
					if(map[cur[0]][cur[1]] == '$') {
						cnt++;
					} else if(map[cur[0]][cur[1]] >= 'a' && map[cur[0]][cur[1]] <= 'z') {
						havenKeys[map[cur[0]][cur[1]] - 'a'] = true;
						for(int r = 0; r < row; r++) {
							for(int c = 0; c < col; c++) {
								if(map[r][c] >= 'a' && map[r][c] <= 'z') {
									if(havenKeys[map[r][c] - 'a']) map[r][c] = '.';
								} else if(map[r][c] >= 'A' && map[r][c] <= 'Z') {
									if(havenKeys[map[r][c] - 'A']) map[r][c] = '.';
								}
							}
						}
						continue findKey;
					} 
					for(int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr < 0 || nr >= row || nc < 0 || nc >= col || map[nr][nc] == '*' || vis[nr][nc] || (map[cur[0]][cur[1]] >= 'A' && map[cur[0]][cur[1]] <= 'Z')) continue;
						que.offer(new int[] {nr, nc});
					}
				}
				System.out.println(cnt);
				break;
			}
		}
	}
}
