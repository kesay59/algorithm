import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17281 {
	
	private static int maxScore = 0;
	private static int[][] scores;
	private static int inning;
	private static boolean[] selected = new boolean[9];
	private static int[] memberList = new int[9];
	private static int hitterIdx;
	
	private static int playInning(int[] scoreList) {
		boolean[] map = new boolean[4];
		int score = 0;
		int outCnt = 0;
		while(outCnt < 3) {
			if(scoreList[memberList[hitterIdx]] == 0) {
				outCnt++;
			} else {
				map[0] = true;
				for(int i = 4 - scoreList[memberList[hitterIdx]]; i < 4; i++) {
					if(map[i]) {
						score++;
						map[i] = false;
					}
				}
				for(int i = 3 - scoreList[memberList[hitterIdx]]; i >= 0 ; i--) {
					if(map[i]) {
						map[i + scoreList[memberList[hitterIdx]]] = true;
						map[i] = false;
					}
				}
			}
			hitterIdx = (hitterIdx + 1) % 9;
		}
		return score;
	}
	
	private static int playGame() {
		hitterIdx = 0;
		int scoreSum = 0;
		for(int i = 0; i < inning; i++) {
			scoreSum += playInning(scores[i]);
		}
		return scoreSum;
	}
	
	private static void simulate(int idx) {
		if(idx >= 9) {
			maxScore = Math.max(maxScore, playGame());
			return;
		} else if(idx == 3) {
			memberList[idx] = 0;
			simulate(idx + 1);
			return;
		}
		for(int i = 1; i < 9; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			memberList[idx] = i;
			simulate(idx + 1);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inning = Integer.parseInt(br.readLine());
		scores = new int[inning][9];
		for(int i = 0; i < inning; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		simulate(0);
		System.out.println(maxScore);
	}
}
