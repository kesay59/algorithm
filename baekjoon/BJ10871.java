import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder answer = new StringBuilder();
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).filter(x -> x < inp[1]).forEach(x -> answer.append(x).append(' '));
        System.out.println(answer.toString());
    }
}
