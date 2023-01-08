import java.io.*;
import java.util.Arrays;

public class BJ1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long win = (long)arr[1] * 100;
        long all = arr[0];
        long prev = win / all;
        if(prev >= 99) {
            System.out.println(-1);
            return;
        }
        long min = 1;
        long max = 1000000000;
        while(min < max) {
            long mid = (max + min) / 2;
            if((win + mid * 100) / (all + mid) != prev) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max);
    }
}