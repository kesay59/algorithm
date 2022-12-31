import java.io.*;
import java.util.*;

public class BJ2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = nm[0];
        int M = nm[1];
        int J = Integer.parseInt(br.readLine());
        int cur = 1;
        int sum = 0;
        for(int j = 0; j < J; j++) {
            int d = Integer.parseInt(br.readLine());
            if(d < cur) {
                int tmp = cur - d;
                cur -= tmp;
                sum += tmp;
            } else if(d > cur + M - 1) {
                int tmp = d - (cur + M - 1);
                cur += tmp;
                sum += tmp;
            }
        }
        System.out.println(sum);
    }
}
