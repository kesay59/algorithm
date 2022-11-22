import java.io.*;
import java.util.*;

public class BJ20186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int k = 0; k < K; k++) {
            sum -= k;
        }
        int[] arr = new int[100001];
        int rm = K;
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(it -> arr[it]++);
        for(int num = 100000; num > 0; num--) {
            if(arr[num] < rm) {
                sum += num * arr[num];
                rm -= arr[num];
            } else {
                sum += num * rm;
                break;
            }
        }
        System.out.println(sum);
    }
}