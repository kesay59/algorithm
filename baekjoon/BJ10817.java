import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxIdx = 0, minIdx = 0;
        for(int i = 0; i < 3; i++) {
            if(arr[maxIdx] < arr[i]) maxIdx = i;
            if(arr[minIdx] > arr[i]) minIdx = i;
        }
        for(int i = 0; i < 3; i++) {
            if(i == maxIdx || i == minIdx) continue;
            System.out.println(arr[i]);
            return;
        }
    }
}
