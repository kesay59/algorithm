import java.io.*;
import java.util.*;

public class BJ1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        int idx = 0;
        for(int num = 1; num <= 1000; num++) {
            for(int n = 0; n < N; n++) {
                if(arr[n] == num) {
                    answer[n] = idx++;
                }
            }
        }
        StringBuilder stb = new StringBuilder();
        Arrays.stream(answer).forEach(i -> stb.append(i).append(' '));
        System.out.println(stb.toString());
    }
}