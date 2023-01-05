import java.io.*;
import java.util.*;

public class BJ2790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int[] after = new int[N];
        for(int n = 0; n < N; n++) {
            after[n] = arr[n] + (N - n);
        }
        int answer = 0;
        int max = 0;
        for(int n = N - 1; n >= 0; n--) {
            if(max < after[n]) {
                max = after[n];
            }
            if(arr[n] + N >= max) {
                answer++;
            } else {
                break;
            }
        }
        System.out.println(answer);
    }
}
