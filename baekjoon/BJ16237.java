import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ16237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        cnt += arr[4];

        cnt += arr[3];
        arr[0] -= arr[3];

        cnt += arr[2];
        arr[1] -= arr[2];

        if(arr[1] > 0) {
            cnt += arr[1] / 2;
            arr[0] -= arr[1] / 2;
            if(arr[1] % 2 != 0) {
                cnt++;
                arr[0] -= 3;
            }
        } else {
            arr[0] -= Math.abs(arr[1]) * 2;
        }

        if(arr[0] > 0) {
            cnt += (arr[0] + 4) / 5;
        }

        System.out.println(cnt);
    }
}