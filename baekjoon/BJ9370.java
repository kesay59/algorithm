import java.io.*;
import java.util.*;

public class BJ9370 {
    private static final int INF = Integer.MAX_VALUE / 2 - 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            Map<Integer, Integer>[] edges = new HashMap[N + 1];
            for(int n = 1; n <= N; n++) {
                edges[n] = new HashMap<>();
            }
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) * 2;
                if(!edges[a].containsKey(b) || edges[a].get(b) > d) {
                    edges[a].put(b, d);
                    edges[b].put(a, d);
                }
            }
            edges[G].put(H, edges[G].get(H) - 1);
            edges[H].put(G, edges[H].get(G) - 1);
            int[] dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[S] = 0;
            boolean[] vis = new boolean[N + 1];
            while(true) {
                int next = 0;
                for(int n = 1; n <= N; n++) {
                    if(!vis[n] && dist[n] < dist[next]) {
                        next = n;
                    }
                }
                if(next == 0) {
                    break;
                }
                vis[next] = true;
                for(Map.Entry<Integer, Integer> edge : edges[next].entrySet()) {
                    dist[edge.getKey()] = Math.min(dist[next] + edge.getValue(), dist[edge.getKey()]);
                }
            }
            List<Integer> answers = new ArrayList<>();
            for(int t = 0; t < T; t++) {
                int target = Integer.parseInt(br.readLine());
                if(dist[target] % 2 == 1) {
                    answers.add(target);
                }
            }
            StringBuilder answer = new StringBuilder();
            answers.stream().sorted().forEach(ans -> answer.append(ans).append(' '));
            System.out.println(answer.toString());
        }
    }
}