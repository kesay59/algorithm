import java.io.*;
import java.util.*;

public class BJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a, b;
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write(Integer.toString(arr[b] - arr[a-1]));
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
}