import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            long[][][] arr = new long[N+N+1][N+1][N+1];
            arr[0][0][0] = 1;
            for(int n = 1; n < arr.length; n++) {
                for(int w = (n + 1) / 2; w <= n && w <= N; w++) {
                    int h = n - w;
                    if(w-1 >= h) arr[n][w][h] += arr[n-1][w-1][h];
                    if(h-1 >= 0) arr[n][w][h] += arr[n-1][w][h-1];
                }
            }
            stb.append(arr[N+N][N][N]).append('\n');
        }
        System.out.println(stb.toString());
    }
}