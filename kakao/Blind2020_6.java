import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private static int N;
    private int[] dp;
    private int target;

    private void repair(int[] weak, int mask, Integer[] friends, int num) {
        if(dp[mask] <= num) return;
        dp[mask] = num;
        if(num >= friends.length || mask == target) return;
        for(int w = 0; w < weak.length; w++) {
            if((mask&(1<<w)) != 0) continue;
            int nextMask = (mask|(1<<w));
            int mv = 0;
            int cur = w, prev;
            while(true) {
                if(cur == weak.length - 1) {
                    mv += N - weak[cur] + weak[0];
                    cur = 0;
                } else {
                    mv += weak[cur + 1] - weak[cur];
                    cur++;
                }
                if(mv > friends[num]) break;
                nextMask |= (1<<cur);
            }
            repair(weak, nextMask, friends, num + 1);
        }

    }

    public int solution(int n, int[] weak, int[] dist) {
        N = n;
        target = (int)Math.pow(2, weak.length) - 1;
        dp = new int[target + 1];
        Arrays.fill(dp, 10);
        Integer[] friends = Arrays.stream(dist).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);
        repair(weak, 0, friends, 0);
        return dp[target] != 10 ? dp[target] : -1;
    }
}