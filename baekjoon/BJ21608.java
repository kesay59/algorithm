import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] likeStudent = new int[N*N+1][4];
		StringTokenizer st;
		int student, maxLikeCnt, maxBlankCnt, likeCnt, blankCnt, sr, sc, tmpR, tmpC;
		int[] dr = new int[] {-1, 0, 1, 0};
		int[] dc = new int[] {0, -1, 0, 1};
		for(int n = 1; n <= N*N; n++) {
			st = new StringTokenizer(br.readLine());
			student = Integer.parseInt(st.nextToken());
			for(int s = 0; s < 4; s++) {
				likeStudent[student][s] = Integer.parseInt(st.nextToken());
			}
			tmpR = tmpC = 0;
			maxLikeCnt = maxBlankCnt = -1;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] != 0) continue;
					likeCnt = blankCnt = 0;
					for(int d = 0; d < 4; d++) {
						sr = r + dr[d];
						sc = c + dc[d];
						if(sr < 0 || sr >= N || sc < 0 || sc >= N) continue;
						for(int s = 0; s < 4; s++) {
							if(map[sr][sc] == likeStudent[student][s]) {
								likeCnt++;
								break;
							}
						}
						if(map[sr][sc] == 0) blankCnt++;
					}
					if(likeCnt > maxLikeCnt || (likeCnt == maxLikeCnt && blankCnt > maxBlankCnt)) {
						maxLikeCnt = likeCnt;
						maxBlankCnt = blankCnt;
						tmpR = r;
						tmpC = c;
					}
				}
			}
			map[tmpR][tmpC] = student;
		}
		int answer = 0;
		int happyCnt;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				happyCnt = 0;
				for(int d = 0; d < 4; d++) {
					sr = r + dr[d];
					sc = c + dc[d];
					if(sr < 0 || sr >= N || sc < 0 || sc >= N) continue;
					for(int s = 0; s < 4; s++) {
						if(map[sr][sc] == likeStudent[map[r][c]][s]) {
							happyCnt++;
						}
					}
				}
				answer += happyCnt == 0 ? 0 : Math.pow(10, happyCnt-1);
			}
		}
		System.out.println(answer);
	}
}
