import java.io.*;
import java.util.*;
import java.util.stream.*;

public class BJ1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cranes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer>[] queues = new LinkedList[N];
        int M = Integer.parseInt(br.readLine());
        Integer[] boxes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        for(int n = 0; n < N; n++) {
            int crane = cranes[n];
            queues[n] = IntStream.range(0, M).dropWhile(idx -> boxes[idx] > crane).boxed().collect(Collectors.toCollection(LinkedList<Integer>::new));
        }
        boolean[] isMoved = new boolean[M];
        int cnt = 0;
        int time = 0;
        for(; time <= 10000; time++) {
            if(cnt == M) {
                break;
            }
            for(int n = 0; n < N; n++) {
                while(!queues[n].isEmpty()) {
                    if(isMoved[queues[n].peek()]) {
                        queues[n].poll();
                    } else {
                        break;
                    }
                }
                if(!queues[n].isEmpty()) {
                    isMoved[queues[n].poll()] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt == M ? time : -1);
    }
}