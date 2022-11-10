import java.io.*;
import java.util.*;

public class BJ1865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        tc : for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N+1][N+1];
            for(int d = 1; d <= N; d++) {
                Arrays.fill(arr[d], Integer.MAX_VALUE / 2);
                arr[d][d] = 0;
            }
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                if(time < arr[s][e]) {
                    arr[s][e] = arr[e][s] = time;
                }
            }
            for(int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                if(-time < arr[s][e]) {
                    arr[s][e] = -time;
                }
            }
            for(int d = 1; d <= N; d++) {
                for(int i = 1; i <= N; i++) {
                    for(int j = 1; j <= N; j++) {
                        if(arr[i][d] + arr[d][j] < arr[i][j]) {
                            arr[i][j] = arr[i][d] + arr[d][j];
                        }
                    }
                }
            }
            for(int d = 1; d <= N; d++) {
                if(arr[d][d] != 0) {
                    System.out.println("YES");
                    continue tc;
                }
            }
            System.out.println("NO");
        }
    }
}