import java.io.*;
import java.util.*;

public class BJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(((double) Arrays.stream(arr).sum()) / Arrays.stream(arr).max().getAsInt() * 100 / arr.length);
    }
}
