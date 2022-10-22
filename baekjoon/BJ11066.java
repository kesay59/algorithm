import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int t = 0; t < tc; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] sum = new int[N+1][N];
            int[][] dp = new int[N+1][N];
            for(int n = 0; n < N; n++) {
                sum[1][n] = Integer.parseInt(st.nextToken());
            }
            for(int l = 2; l <= N; l++) {
                Arrays.fill(dp[l], Integer.MAX_VALUE);
                for(int n = 0; n <= N - l; n++) {
                    int minK = 0;
                    sum[l][n] = sum[1][n] + sum[l-1][n+1];
                    for(int k = 1; k < l; k++) {
                        if(dp[l][n] > sum[l][n] + dp[k][n] + dp[l-k][n+k]) {
                            dp[l][n] = sum[l][n] + dp[k][n] + dp[l-k][n+k];
                        }
                    }
                }
            }
            bw.write(dp[N][0] + "\n");
        }
        bw.flush();
        bw.close();
    }
}