import java.io.*;
import java.util.*;

public class BJ10021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] loc = new int[N][];
        int[][] cost = new int[N][N];
        for(int n = 0; n < N; n++) {
            loc[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i = 0; i < n; i++) {
                int value = (loc[i][0] - loc[n][0]) * (loc[i][0] - loc[n][0]) + (loc[i][1] - loc[n][1]) * (loc[i][1] - loc[n][1]);
                if(value >= C) {
                    cost[i][n] = cost[n][i] = value;
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0});
        boolean[] vis = new boolean[N];
        long answer = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(vis[cur[0]]) {
                continue;
            }
            vis[cur[0]] = true;
            answer += cur[1];
            for(int n = 0; n < N; n++) {
                if(vis[n] || cost[cur[0]][n] == 0) {
                    continue;
                }
                pq.offer(new int[] {n, cost[cur[0]][n]});
            }
        }
        for(int n = 0; n < N; n++) {
            if(!vis[n]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }
}
