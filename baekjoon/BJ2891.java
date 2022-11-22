import java.io.*;
import java.util.*;

public class BJ2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        boolean[] broken = new boolean[N+2];
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> broken[it] = true);
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> {
            if(broken[it]) {
                broken[it] = false;
            } else {
                if(broken[it-1]) {
                    broken[it-1] = false;
                } else if(broken[it+1]) {
                    broken[it+1] = false;
                }
            }
        });
        int cnt = 0;
        for(int n = 1; n <= N; n++) {
            if(broken[n]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}