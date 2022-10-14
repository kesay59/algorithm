import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ20058 {

    private static int[] dr = new int[] {-1, 0, 1, 0};
    private static int[] dc = new int[] {0, -1, 0, 1};

    private static int countConnection(int[][] map, boolean[][] vis, int r, int c) {
        vis[r][c] = true;
        int sum = 1;
        int nr, nc;
        for(int d = 0; d < 4; d++) {
            nr = r + dr[d];
            nc = c + dc[d];
            if(nr < 0 || nr >= map.length || nc < 0 || nc >= map.length || vis[nr][nc] || map[nr][nc] == 0) continue;
            sum += countConnection(map, vis, nr, nc);
        }
        return sum;
    }

    private static void remove(int[][] map) {
        Queue<Integer> stk = new LinkedList<>();
        for(int r = 0; r < map.length; r++) {
            for(int c = 0; c < map.length; c++) {
                int count = 0;
                int nr, nc;
                for(int d = 0; d < 4; d++) {
                    nr = r + dr[d];
                    nc = c + dc[d];
                    if(nr < 0 || nr >= map.length || nc < 0 || nc >= map.length || map[nr][nc] == 0) continue;
                    count++;
                }
                if(count < 3) {
                    stk.offer(r);
                    stk.offer(c);
                }
            }
        }
        int r, c;
        while(!stk.isEmpty()) {
            r = stk.poll();
            c = stk.poll();
            if(map[r][c] > 0) map[r][c]--;
        }
    }

    private static void spin(int[][] map, int stdR, int stdC, int len) {
        int tmp;
        for(int i = 0; i < len / 2; i++) {
            for(int j = i; j < len - i - 1; j++) {
                tmp = map[stdR + i][stdC + j];
                map[stdR + i][stdC + j] = map[stdR + len - 1 - j][stdC + i];
                map[stdR + len - 1 - j][stdC + i] = map[stdR + len - 1 - i][stdC + len - 1 - j];
                map[stdR + len - 1 - i][stdC + len - 1 - j] = map[stdR + j][stdC + len - 1 - i];
                map[stdR + j][stdC + len - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);
        int[][] map = new int[len][len];
        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int q = 0; q < Q; q++) {
            int l = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
            for(int r = 0; r < len; r += l) {
                for(int c = 0; c < len; c += l) {
                    spin(map, r, c, l);
                }
            }
            remove(map);
        }
        int sum = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
        int maxValue = 0;
        boolean[][] vis = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(!vis[i][j] && map[i][j] > 0) {
                    maxValue = Math.max(maxValue, countConnection(map, vis, i, j));
                }
            }
        }
        System.out.println(maxValue);
    }

}