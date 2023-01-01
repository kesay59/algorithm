import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, String> hm = new HashMap<>();
        for(int n = 0; n < nm[0]; n++) {
            String[] str = br.readLine().split(" ");
            hm.put(str[0], str[1]);
        }
        for(int m = 0; m < nm[1]; m++) {
            System.out.println(hm.get(br.readLine()));
        }
    }
}