import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        testCase: while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            List<Integer> list = new ArrayList<>();
            for(int n = 0; n < N; n++) {
                list.add(Integer.parseInt(br.readLine()));
            }
            list.sort(Comparator.naturalOrder());
            for(int n = 1; n < N; n++) {
                if(list.get(n) - list.get(n-1) > 200) {
                    answer.append("IMPOSSIBLE\n");
                    continue testCase;
                }
            }
            if(1422 - list.get(N-1) > 100) {
                answer.append("IMPOSSIBLE\n");
                continue testCase;
            }
            answer.append("POSSIBLE\n");
        }
        System.out.println(answer.toString());
    }
}