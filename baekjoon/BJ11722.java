import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int answer = 0;
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            dp[n] = 1;
            for(int b = n - 1; b >= 0; b--) {
                if(arr[b] > arr[n]) {
                    dp[n] = Math.max(dp[n], dp[b] + 1);
                }
            }
            answer = Math.max(dp[n], answer);
        }
        System.out.println(answer);
    }
}
