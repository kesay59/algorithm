import java.io.*;
import java.util.*;

public class BJ1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[N+1];
        for(int n = 2; n <= N; n++) {
            if(!arr[n]) {
                list.add(n);
                for(int k = n; k <= N; k += n) {
                    arr[k] = true;
                }
            }
        }
        int first = 0;
        int last = 0;
        int sum = 0;
        int cnt = 0;
        while(true) {
            if(sum <= N) {
                if(sum == N) {
                    cnt++;
                }
                if(first >= list.size()) {
                    break;
                }
                sum += list.get(first);
                first++;
            } else if(sum > N) {
                sum -= list.get(last);
                last++;
            }
        }
        System.out.println(cnt);
    }
}