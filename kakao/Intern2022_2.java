import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[][] queue = new int[2][];
        queue[0] = queue1;
        queue[1] = queue2;
        Queue<Integer>[] que = new LinkedList[2];
        long[] sum = new long[2];
        for(int i = 0; i < 2; i++) {
            que[i] = new LinkedList<>();
            final int k = i;
            Arrays.stream(queue[i]).forEach(e -> {
                sum[k] += e;
                que[k].offer(e);
            });
        }
        int cnt = 0;
        for(int i = 0; i < queue1.length*3; i++) {
            if(sum[0] == sum[1]) break;
            int p = sum[0] > sum[1] ? 0 : 1;
            int cur = que[p].poll();
            que[p^1].offer(cur);
            sum[p] -= cur;
            sum[p^1] += cur;
            cnt++;
        }
        if(cnt >= queue1.length*3) return -1;
        return cnt;
    }
}