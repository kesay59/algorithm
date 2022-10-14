import java.io.*;
import java.util.*;

public class BJ14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char d = st.nextToken().charAt(0);
        int[] arr = new int['9' + 1];
        for(int n = 1; n <= N; n++) {
            char[] chars = Integer.toString(n).toCharArray();
            for(char ch : chars) {
                arr[ch]++;
            }
        }
        System.out.println(arr[d]);
    }
}
