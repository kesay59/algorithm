import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N+1][M+1];
        arr[0][S] = true;
        st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            int num = Integer.parseInt(st.nextToken());
            for(int m = 0; m <= M; m++) {
                if(arr[n-1][m]) {
                    if(m+num <= M) arr[n][m+num] = true;
                    if(m-num >= 0) arr[n][m-num] = true;
                }
            }
        }
        int answer = -1;
        for(int m = M; m >= 0; m--) {
            if(arr[N][m]) {
                answer = m;
                break;
            }
        }
        System.out.println(answer);
    }
}