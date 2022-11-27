import java.io.*;
import java.util.*;

public class BJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int min = 0;
        int max = 1000000000;
        int value = 0, answer = 0;
        while(min <= max) {
            value = (max + min) / 2;
            int cnt = 1;
            int prev = 0;
            for(int idx = 1; idx < arr.length; idx++) {
                if(arr[idx] - arr[prev] >= value) {
                    prev = idx;
                    cnt++;
                }
            }
            if(cnt >= C) {
                answer = value;
                min = value + 1;
            } else {
                max = value - 1;
            }
        }
        System.out.println(answer);
    }
}