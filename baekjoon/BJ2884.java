import java.io.*;
import java.util.*;

public class BJ2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr[1] -= 45;
        if(arr[1] < 0) {
            arr[0]--;
            arr[1] += 60;
        }
        if(arr[0] == -1) {
            arr[0] = 23;
        }
        System.out.printf("%d %d", arr[0], arr[1]);
    }
}