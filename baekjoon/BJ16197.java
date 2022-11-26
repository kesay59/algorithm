import java.io.*;
import java.util.StringTokenizer;

public class BJ16197 {
    private static int answer = 11;
    private static int R, C;
    private static char[][] map;
    private static int[] dr = new int[] {-1, 0, 1, 0};
    private static int[] dc = new int[] {0, -1, 0, 1};

    private static void move(int r1, int c1, int r2, int c2, int cnt) {
        if(cnt >= answer) {
            return;
        }
        if(r1 < 0 || r1 >= R || c1 < 0 || c1 >= C) {
            if(r2 >= 0 && r2 < R && c2 >= 0 && c2 < C) {
                answer = cnt;
            }
            return;
        } else if(r2 < 0 || r2 >= R || c2 < 0 || c2 >= C) {
            answer = cnt;
            return;
        }
        for(int d = 0; d < 4; d++) {
            int nr1 = r1 + dr[d];
            int nc1 = c1 + dc[d];
            if(nr1 >= 0 && nr1 < R && nc1 >= 0 && nc1 < C && map[nr1][nc1] == '#') {
                nr1 = r1;
                nc1 = c1;
            }
            int nr2 = r2 + dr[d];
            int nc2 = c2 + dc[d];
            if(nr2 >= 0 && nr2 < R && nc2 >= 0 && nc2 < C && map[nr2][nc2] == '#') {
                nr2 = r2;
                nc2 = c2;
            }
            move(nr1, nc1, nr2, nc2, cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        for(int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }
        int[][] coin = new int[2][];
        int idx = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(map[r][c] == 'o') {
                    coin[idx] = new int[] {r, c};
                    idx++;
                }
            }
        }
        move(coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0);
        System.out.println(answer > 10 ? -1 : answer);
    }
}