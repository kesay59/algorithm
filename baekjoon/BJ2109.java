import java.io.*;
import java.util.*;

public class BJ2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][];
        for(int n = 0; n < N; n++) {
            arr[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(arr, (job1, job2) -> job2[1] - job1[1]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((job1, job2) -> job2[0] - job1[0]);
        int answer = 0;
        int idx = 0;
        for(int time = 10000; time > 0; time--) {
            while(idx < arr.length && arr[idx][1] >= time) {
                priorityQueue.offer(arr[idx]);
                idx++;
            }
            if(!priorityQueue.isEmpty()) {
                answer += priorityQueue.poll()[0];
            }
        }
        System.out.println(answer);
    }
}
// 기한 긴 순서로 정렬
// 해당 시간에 참석 가능한 강의만 우선순위큐에 추가하고 가치가 가장 높은 강의 선택
// 10000부터 1까지 반복