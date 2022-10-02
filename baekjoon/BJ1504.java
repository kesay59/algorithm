import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] route = new int[N][N];
        for(int n = 0; n < N; n++) {
            Arrays.fill(route[n], Integer.MAX_VALUE / 4);
        }
        int from, to, cost;
        for(int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken()) - 1;
            to = Integer.parseInt(st.nextToken()) - 1;
            cost = Integer.parseInt(st.nextToken());
            route[from][to] = cost;
            route[to][from] = cost;
        }
        for(int idx = 0; idx < N; idx++) {
            route[idx][idx] = 0;
        }
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    route[i][j] = Math.min(route[i][j], route[i][k] + route[k][j]);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()) - 1;
        int v2 = Integer.parseInt(st.nextToken()) - 1;
        int answer = Math.min(route[0][v1] + route[v1][v2] + route[v2][N-1], route[0][v2] + route[v2][v1] + route[v1][N-1]);
        System.out.println(answer >= Integer.MAX_VALUE / 4 ? -1 : answer);
    }
}