import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] dist = new int[N-1];
        for(int i = 0; i < N-1; i++) {
            dist[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(dist);
        int count = N - K;
        int sum = 0;
        for(int c = 0; c < count; c++) {
            sum += dist[c];
        }
        System.out.println(sum);
    }
}