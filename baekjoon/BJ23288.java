import java.io.*;
import java.util.*;

public class BJ23288 {
    private static int[][][][] nextDice = new int[][][][] {
            {},
            {{}, {}, {{2, 6}, {4, 2}, {5, 1}, {3, 2}}, {{3, 6}, {2, 3}, {4, 1}, {5, 3}}, {{4, 6}, {5, 4}, {3, 1}, {2, 4}}, {{5, 6}, {3, 5}, {2, 1}, {4, 5}}, {}},
            {{}, {{1, 5}, {3, 1}, {6, 2}, {4, 1}}, {}, {{3, 5}, {6, 3}, {4, 2}, {1, 3}}, {{4, 5}, {1, 4}, {3, 2}, {6, 4}}, {}, {{6, 5}, {4, 6}, {1, 2}, {3, 6}}},
            {{}, {{1, 4}, {5, 1}, {6, 3}, {2, 1}}, {{2, 4}, {1, 2}, {5, 3}, {6, 2}}, {}, {}, {{5, 4}, {6, 5}, {2, 3}, {1, 5}}, {{6, 4}, {2, 6}, {1, 3}, {5, 6}}},
            {{}, {{1, 3}, {2, 1}, {6, 4}, {5, 1}}, {{2, 3}, {6, 2}, {5, 4}, {1, 2}}, {}, {}, {{5, 3}, {1, 5}, {2, 4}, {6, 5}}, {{6, 3}, {5, 6}, {1, 4}, {2, 6}}},
            {{}, {{1, 2}, {4, 1}, {6, 5}, {3, 1}}, {}, {{3, 2}, {1, 3}, {4, 5}, {6, 3}}, {{4, 2}, {6, 4}, {3, 5}, {1, 4}}, {}, {{6, 2}, {3, 6}, {1, 5}, {4, 6}}},
            {{}, {}, {{2, 1}, {3, 2}, {5, 6}, {4, 2}}, {{3, 1}, {5, 3}, {4, 6}, {2, 3}}, {{4, 1}, {2, 4}, {3, 6}, {5, 4}}, {{5, 1}, {4, 5}, {2, 6}, {3, 5}}, {}}
    };
    private static int[] dr = new int[] {-1, 0, 1, 0};
    private static int[] dc = new int[] {0, 1, 0, -1};
    private static int N, M;
    private static int search(int[][] map, int[][] score, int r, int c) {
        score[r][c] = -1;
        int sum = map[r][c];
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[r][c] != map[nr][nc] || score[nr][nc] == -1) {
                continue;
            }
            sum += search(map, score, nr, nc);
        }
        return sum;
    }
    private static void save(int[][] score, int r, int c, int value) {
        score[r][c] = value;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || score[nr][nc] != -1) {
                continue;
            }
            save(score, nr, nc, value);
        }
    }
    private static int setDirection(int dice, int bot, int dir) {
        if(dice > bot) {
            return (dir + 1) % 4;
        } else if(dice < bot) {
            return (dir - 1 + 4) % 4;
        } else {
            return dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][];
        for(int n = 0; n < N; n++) {
            map[n] = br.readLine().replaceAll(" ", "").chars().map(ch -> ch - '0').toArray();
        }
        int[][] score = new int[N][M];
        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                if(score[n][m] == 0) {
                    save(score, n, m, search(map, score, n, m));
                }
            }
        }
        int answer = 0;
        int r = 0, c = 0, dir = 1;
        int[] dice = new int[] {6, 2};
        for(int k = 0; k < K; k++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
                dir = (dir + 2) % 4;
            }
            dice = nextDice[dice[0]][dice[1]][dir];
            r += dr[dir];
            c += dc[dir];
            answer += score[r][c];
            dir = setDirection(dice[0], map[r][c], dir);
        }
        System.out.println(answer);
    }
}