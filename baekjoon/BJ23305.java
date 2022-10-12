import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ23305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            arr[Integer.parseInt(st.nextToken())]--;
        }
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) sum -= arr[i];
        }
        System.out.println(sum);
    }
}