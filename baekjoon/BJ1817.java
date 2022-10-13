import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if(N == 0) {
            System.out.println(0);
            System.exit(0);
        }
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cnt = 0, sum = M, cur;
        for(int n = 0; n < N; n++) {
            cur = Integer.parseInt(st.nextToken());
            if(M - sum < cur) {
                sum = cur;
                cnt++;
            } else {
                sum += cur;
            }
        }
        System.out.println(cnt);
    }
}