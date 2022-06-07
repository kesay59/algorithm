import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ1014 {
	
	private static int row, col, maxMask;
	private static char map[][];
	
	private static byte cur;
	private static int[][] score;
	private static Map<Integer, Set<Integer>>[] maskTable;
	
	private static void makeMask(int preMask, int curMask, int r, int idx, int cnt) {
		if(idx >= col) {
			if(!maskTable[cur].containsKey(curMask)) maskTable[cur].put(curMask, new HashSet<>());
			maskTable[cur].get(curMask).add(preMask);
			score[cur][curMask] = cnt;
			return;
		}
		if(map[r][idx] == 'x'
				|| (idx > 0 && (preMask & (1<<(idx-1))) != 0) 
				|| (preMask & (1<<(idx+1))) != 0
				|| (idx > 0 && (curMask & (1<<(idx-1))) != 0)) {
			makeMask(preMask, curMask, r, idx+1, cnt);
		} else {
			makeMask(preMask, curMask^(1<<idx), r, idx+1, cnt+1);
			makeMask(preMask, curMask, r, idx+1, cnt);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			maxMask = (int) Math.pow(2, col);
			
			map = new char[row][];
			for(int r = 0; r < row; r++) {
				map[r] = br.readLine().toCharArray();
			}

			cur = 0;
			score = new int[2][maxMask];
			maskTable = new HashMap[2];
			maskTable[0] = new HashMap<>();
			maskTable[1] = new HashMap<>();
			maskTable[1].put(0, new HashSet<>());
			
			for(int r = 0; r < row; r++) {
				Arrays.fill(score[cur], 0);
				maskTable[cur] = new HashMap<>();
				for(int preMask : maskTable[cur^1].keySet()) {					
					makeMask(preMask, 0, r, 0, 0);
				}
				for(int curMask : maskTable[cur].keySet()) {
					int curCnt = score[cur][curMask];
					for(int preMask : maskTable[cur].get(curMask)) {
						score[cur][curMask] = Math.max(score[cur^1][preMask] + curCnt, score[cur][curMask]);
					}
				}
				cur ^= 1;
			}
			
			cur ^= 1;
			int maxScore = 0;
			for(int curMask : maskTable[cur].keySet()) {
				maxScore = Math.max(maxScore, score[cur][curMask]);
			}
			System.out.println(maxScore);
		}
		
	}
}
