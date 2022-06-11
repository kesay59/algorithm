import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ1079 {
	private static int num;
	private static int[] guiltyScore;
	private static int[][] guiltyTable;
	private static int ej;
	private static boolean[] deadUser;
	private static int maxNightCnt = 0;
	
	private static void playTurn(int userCnt, int nightCnt) {
		if(userCnt <= 1 || deadUser[ej]) {
			maxNightCnt = Math.max(maxNightCnt, nightCnt);
			return;
		}
		if(userCnt % 2 == 0) {
			for(int i = 0; i < num; i++) {				
				if(!deadUser[i]) {
					deadUser[i] = true;
					for(int j = 0; j < num; j++) {
						if(!deadUser[j]) guiltyScore[j] += guiltyTable[i][j];
					}
					playTurn(userCnt - 1, nightCnt + 1);
					for(int j = 0; j < num; j++) {
						if(!deadUser[j]) guiltyScore[j] -= guiltyTable[i][j];
					}
					deadUser[i] = false;
				}
			}
		} else {
			int selIdx = ej;
			for(int i = num - 1; i >= 0; i--) {
				if(!deadUser[i] && guiltyScore[i] >= guiltyScore[selIdx]) selIdx = i;
			}
			deadUser[selIdx] = true;
			playTurn(userCnt - 1, nightCnt);
			deadUser[selIdx] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		guiltyScore = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num; i++) {
			guiltyScore[i] = Integer.parseInt(st.nextToken());
		}
		guiltyTable = new int[num][num];
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < num; j++) {
				guiltyTable[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ej = Integer.parseInt(br.readLine());
		deadUser = new boolean[num];
		playTurn(num, 0);
		System.out.println(maxNightCnt);
	}
}
