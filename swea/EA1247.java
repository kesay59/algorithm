import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SW ExpertAcademy 1247 최적경로
public class EA1247 {
	private static int[][] lut = new int[12][12];
	private static int[][] dot = new int[12][2];
	private static int min;
	private static int aLen, cLen;
	private static boolean visited[];
	private static int[] tmp = new int[12];
	
	private static void visit(int dp, int cur, int sum) {
		if(sum > min) return;
		if(dp == cLen + 1) {
			if(min > sum + lut[cur][cLen+1]) {
				min = sum + lut[cur][cLen+1];
			}
			return;
		}
		
		for(int i = 1; i < cLen + 1 ; i++) {
			if(visited[cur]) continue;
			visited[cur] = true;
			visit(dp + 1, i, sum + lut[cur][i]);
			visited[cur] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= test_case; tc++) {
			min = Integer.MAX_VALUE;
			visited = new boolean[12];
			cLen = Integer.parseInt(br.readLine());
			aLen = cLen + 2;
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 2; i++) {
				dot[(cLen + 1) * i][0] = Integer.parseInt(st.nextToken());
				dot[(cLen + 1) * i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1; i < cLen + 1; i++) {
				dot[i][0] = Integer.parseInt(st.nextToken());
				dot[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0; i < aLen; i++) 
				for(int j = i; j < aLen; j++) 
					lut[i][j] = lut[j][i] = Math.abs(dot[i][0] - dot[j][0]) + Math.abs(dot[i][1] - dot[j][1]);
			
			visit(0, 0, 0);
			
			System.out.println("#"+tc + " " + min);
			
		}
	}

}
