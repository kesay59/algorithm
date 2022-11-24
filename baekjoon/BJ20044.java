import java.io.*;
import java.util.*;

public class BJ20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length / 2; i++) {
            min = Math.min(min, arr[i] + arr[arr.length - 1 - i]);
        }
        System.out.println(min);
    }
}