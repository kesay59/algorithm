import java.io.*;
import java.util.*;

public class BJ15591 {
    private static int N;
    private static int[][] usado;
    private static List<Integer>[] route;
    private static boolean[] vis;
    private static void search(int prev, int cur) {
        if(vis[cur]) {
            return;
        }
        vis[cur] = true;
        for(int n = 1; n <= N; n++) {
            if(n == cur) {
                continue;
            }
            if(usado[prev][n] != 0) {
                usado[cur][n] = usado[n][cur] = Math.min(usado[prev][n], usado[prev][cur]);
            }
        }
        for(int next : route[cur]) {
            search(cur, next);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        usado = new int[N+1][N+1];
        route = new ArrayList[N+1];
        for(int n = 0; n <= N; n++) {
            route[n] = new ArrayList<>();
        }
        for(int n = 1; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            route[p].add(q);
            route[q].add(p);
            usado[p][q] = usado[q][p] = r;
        }
        vis = new boolean[N+1];
        search(0, 1);
        StringBuilder answer = new StringBuilder();
        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int val : usado[v]) {
                if(val >= k) {
                    cnt++;
                }
            }
            answer.append(cnt).append('\n');
        }
        System.out.println(answer.toString());
    }
}