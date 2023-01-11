import java.io.*;
import java.util.*;

public class BJ14468 {
    private static int[] dr = new int[] {-1, 0, 1, 0};
    private static int[] dc = new int[] {0, -1, 0, 1};
    private static void mark(int[][] map, boolean[][][][] road, int sig, int r, int c) {
        if(map[r][c] != 0) {
            return;
        }
        map[r][c] = sig;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr > 0 && nr < map.length && nc > 0 && nc < map[r].length && !road[r][c][nr][nc]) {
                mark(map, road, sig, nr, nc);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        boolean[][][][] road = new boolean[N+1][N+1][N+1][N+1];
        for(int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            road[r1][c1][r2][c2] = true;
            road[r2][c2][r1][c1] = true;
        }
        int[][] map = new int[N+1][N+1];
        int sig = 1;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j] == 0) {
                    mark(map, road, sig++, i, j);
                }
            }
        }
        int answer = 0;
        List<int[]> cow = new ArrayList<>();
        for(int k = 0; k < K; k++) {
            int[] cur = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int[] prev : cow) {
                if(map[cur[0]][cur[1]] != map[prev[0]][prev[1]]) {
                    answer++;
                }
            }
            cow.add(cur);
        }
        System.out.println(answer);
    }
}
