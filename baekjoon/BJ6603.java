import java.io.*;
import java.util.*;

public class BJ6603 {
    private static StringBuilder answer = new StringBuilder();
    private static void select(int[] arr, int idx, int[] sel, int cur) {
        if(cur == 6) {
            Arrays.stream(sel).forEach(el -> answer.append(el).append(' '));
            answer.append('\n');
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sel[cur] = arr[idx];
        select(arr, idx+1, sel, cur+1);
        select(arr, idx+1, sel, cur);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String line = br.readLine();
            if(line.equals("0")) {
                break;
            }
            int[] arr = Arrays.stream(line.split(" ")).skip(1).mapToInt(Integer::parseInt).sorted().toArray();
            select(arr, 0, new int[6], 0);
            answer.append('\n');
        }
        System.out.print(answer.toString());
    }
}
