import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
            sum += arr[n];
        }
        Arrays.sort(arr);
        long cost = 0;
        for(int n = 0; n < N; n++) {
            cost += arr[n] * (sum -= arr[n]);
        }
        System.out.println(cost);
    }

}