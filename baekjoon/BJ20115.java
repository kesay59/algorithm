import java.io.*;
import java.util.*;

public class BJ20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double max = Arrays.stream(arr).max().orElseThrow();
        double sum = (Arrays.stream(arr).sum() - max) / 2;
        System.out.println(max + sum);
    }
}
