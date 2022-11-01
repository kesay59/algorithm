import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BJ1708 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dots = new int[N][2];
        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots[n][0] = Integer.parseInt(st.nextToken());
            dots[n][1] = Integer.parseInt(st.nextToken());
        }
        int stdIdx = IntStream.range(0, N).boxed().min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return dots[o1][1] == dots[o2][1] ? dots[o1][0] - dots[o2][0] : dots[o1][1] - dots[o2][1];
            }
        }).orElseThrow();
        double[] angles = IntStream.range(0, N).mapToDouble(n -> Math.atan2(dots[n][1] - dots[stdIdx][1], dots[n][0] - dots[stdIdx][0])).toArray();
        double[] dist = IntStream.range(0, N).mapToDouble(n -> Math.pow(dots[stdIdx][0] - dots[n][0], 2) + Math.pow(dots[stdIdx][1] - dots[n][1], 2)).toArray();
        int[] dotIdxSorted = IntStream.range(0, N).boxed().sorted(new Comparator<Integer>() {
            private final double EPSILON = Math.ulp(1.0);
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(angles[o1] - angles[o2]) < EPSILON) {
                    return dist[o1] < dist[o2] ? -1 : 1;
                }
                return angles[o1] < angles[o2] ? -1 : 1;
            }
        }).mapToInt(Integer::intValue).toArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(dotIdxSorted[0]);
        IntStream.concat(Arrays.stream(dotIdxSorted), IntStream.of(dotIdxSorted[0])).skip(1).forEach(cur -> {
            int p1, p2;
            while(stack.size() >= 2) {
                p2 = stack.pop();
                p1 = stack.peek();
                if((long)dots[p1][0] * (dots[p2][1] - dots[cur][1]) + (long)dots[p2][0] * (dots[cur][1] - dots[p1][1]) + (long)dots[cur][0] * (dots[p1][1] - dots[p2][1]) > 0) {
                    stack.push(p2);
                    break;
                }
            }
            stack.push(cur);
        });
        System.out.println(stack.size() - 1);
    }
}