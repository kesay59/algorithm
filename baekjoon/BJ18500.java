import java.io.*;
import java.util.*;

public class BJ18500 {
    private static int R, C;
    private static int[] dr = new int[] {1, 0, 0, -1};
    private static int[] dc = new int[] {0, -1, 1, 0};
    private static boolean drop(char[][] map, boolean[][] ground, List<int[]> bottomList) {
        for(int r = R - 2; r >= 0; r--) {
            for(int c = 0; c < C; c++) {
                if(map[r][c] == 'x' && !ground[r][c]) {
                    map[r+1][c] = 'x';
                    map[r][c] = '.';
                }
            }
        }
        for(int[] bottom : bottomList) {
            bottom[0]++;
            if(bottom[0] == R-1 || ground[bottom[0]+1][bottom[1]]) {
                return false;
            }
        }
        return true;
    }
    private static List<int[]> findBottomList(char[][] map, boolean[][] ground) {
        List<int[]> bottomList = new ArrayList<>();
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(map[r][c] == 'x' && !ground[r][c] && map[r+1][c] == '.') {
                    bottomList.add(new int[] {r, c});
                }
            }
        }
        return bottomList;
    }
    private static boolean[][] mark(char[][] map) {
        boolean[][] ground = new boolean[R][C];
        Queue<Integer> queue = new LinkedList<>();
        int i, j, ni, nj;
        for(int c = 0; c < C; c++) {
            if(map[R-1][c] == 'x' && !ground[R-1][c]) {
                queue.offer(R-1);
                queue.offer(c);
                while(!queue.isEmpty()) {
                    i = queue.poll();
                    j = queue.poll();
                    if(ground[i][j]) {
                        continue;
                    }
                    ground[i][j] = true;
                    for(int d = 0; d < 4; d++) {
                        ni = i + dr[d];
                        nj = j + dc[d];
                        if(ni < 0 || ni >= R || nj < 0 || nj >= C || map[ni][nj] != 'x' || ground[ni][nj]) {
                            continue;
                        }
                        queue.offer(ni);
                        queue.offer(nj);
                    }
                }
            }
        }
        return ground;
    }
    private static void crash(char[][] map, int line, int dir) {
        int c = 0;
        int lim = map[line].length;
        int ad = 1;
        if(dir == 1) {
            c = map[line].length - 1;
            lim = -1;
            ad = -1;
        }
        for(; c != lim; c += ad) {
            if(map[line][c] == 'x') {
                map[line][c] = '.';
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][];
        for(int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            int line = R - Integer.parseInt(st.nextToken());
            crash(map, line, n % 2);
            boolean[][] ground = mark(map);
            List<int[]> bottomList = findBottomList(map, ground);
            if(bottomList.size() > 0) {
                while(drop(map, ground, bottomList));
            }
        }
        StringBuilder stb = new StringBuilder();
        for(int r = 0; r < R; r++) {
            stb.append(map[r]).append('\n');
        }
        System.out.println(stb.toString());
    }
}