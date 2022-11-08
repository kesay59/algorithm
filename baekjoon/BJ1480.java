import java.io.*;
import java.util.*;

public class BJ1480 {
    private static int N, M, C;
    private static int[] jewels;
    private static int[][] dp;
    private static void select(int jewel, int bagCnt, int weight) {
        if(bagCnt >= M || dp[bagCnt][jewel] <= weight) {
            return;
        }
        dp[bagCnt][jewel] = weight;
        for(int n = 0; n < N; n++) {
            if((jewel&(1<<n)) != 0 || weight + jewels[n] > C) {
                continue;
            }
            select(jewel|(1<<n), bagCnt, weight + jewels[n]);
        }
        select(jewel, bagCnt+1, 0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        jewels = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[M][(int)Math.pow(2, N)];
        for(int m = 0; m < M; m++) {
            Arrays.fill(dp[m], Integer.MAX_VALUE);
        }
        select(0, 0, 0);
        int answer = 0;
        for(int m = 0; m < M; m++) {
            for(int j = 0; j < dp[m].length; j++) {
                if(dp[m][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int cnt = 0;
                for(int n = 0; n < N; n++) {
                    if((j&(1<<n)) != 0) {
                        cnt++;
                    }
                }
                answer = Math.max(answer, cnt);
            }
        }
        System.out.println(answer);
    }
}