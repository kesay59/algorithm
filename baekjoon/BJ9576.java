import java.io.*;
import java.util.*;

public class BJ9576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < testCase; tc++) {
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = nm[0];
            int M = nm[1];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            for(int m = 0; m < M; m++) {
                pq.offer(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            PriorityQueue<int[]> stud = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            int cnt = 0;
            for(int n = 1000; n > 0; n--) {
                while(!pq.isEmpty() && pq.peek()[1] == n) {
                    stud.offer(pq.poll());
                }
                while(!stud.isEmpty() && stud.peek()[0] > n) {
                    stud.poll();
                }
                if(!stud.isEmpty()) {
                    stud.poll();
                    cnt++;
                }
            }
            answer.append(cnt).append('\n');
        }
        System.out.print(answer.toString());
    }
}