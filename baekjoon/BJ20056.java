import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ20056 {
    private static int N;
    private static int[] dr = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
    private static void split(Stack<int[]> location, Stack<int[]> remainingFireballs) {
        int cnt = location.size();
        int[] prevFireball = location.pop();
        boolean isSameDir = true;
        int[] fireball;
        while(!location.isEmpty()) {
            fireball = location.pop();
            prevFireball[2] += fireball[2];
            prevFireball[3] += fireball[3];
            if(prevFireball[4] % 2 != fireball[4] % 2) isSameDir = false;
            fireball[5] = 0;
        }
        if(prevFireball[2] >= 5) {
            fireball = new int[] {
                    prevFireball[0],
                    prevFireball[1],
                    prevFireball[2] / 5,
                    prevFireball[3] / cnt,
                    isSameDir ? 0 : 1,
                    1
            };
            for(int c = 0; c < 4; c++, fireball[4] += 2) {
                remainingFireballs.push(fireball.clone());
            }
        }
    }
    private static int[] move(int[] fireball) {
        fireball[0] = (fireball[0] + dr[fireball[4]] * fireball[3]) % N;
        if(fireball[0] < 0) fireball[0] += N;
        fireball[1] = (fireball[1] + dc[fireball[4]] * fireball[3]) % N;
        if(fireball[1] < 0) fireball[1] += N;
        return fireball;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Stack<int[]>[][] map = new Stack[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = new Stack<>();
            }
        }
        Stack<int[]> remainingFireballs = new Stack<>();
        Stack<int[]> movedFireballs = new Stack<>();
        int r, c;
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            int[] fireball = new int[] {
                    r,
                    c,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    1
            };
            remainingFireballs.push(fireball);
        }
        for(int k = 0; k < K; k++) {
            int[] fireball;
            while(!remainingFireballs.isEmpty()) {
                fireball = remainingFireballs.pop();
                move(fireball);
                map[fireball[0]][fireball[1]].push(fireball);
                movedFireballs.push(fireball);
            }
            while(!movedFireballs.isEmpty()) {
                fireball = movedFireballs.pop();
                if(fireball[5] == 0) continue;
                if(map[fireball[0]][fireball[1]].size() > 1) {
                    split(map[fireball[0]][fireball[1]], remainingFireballs);
                } else {
                    map[fireball[0]][fireball[1]].pop();
                    remainingFireballs.push(fireball);
                }
            }
        }
        int sum = 0;
        while(!remainingFireballs.isEmpty()) {
            sum += remainingFireballs.pop()[2];
        }
        System.out.println(sum);
    }
}