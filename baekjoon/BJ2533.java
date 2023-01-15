import java.io.*;
import java.util.*;

public class BJ2533 {
    private static List<Integer>[] friend;
    private static int[][] memo;
    private static int search(int cur, int parent, boolean parentStatus) {
        if(memo[cur][0] == -1) {
            int sum = 1;
            for(int f : friend[cur]) {
                if(f != parent) {
                    sum += search(f, cur, true);
                }
            }
            memo[cur][0] = sum;
        }
        if(memo[cur][1] == -1) {
            int sum = 0;
            for(int f : friend[cur]) {
                if(f != parent) {
                    sum += search(f, cur, false);
                }
            }
            memo[cur][1] = Math.min(sum, memo[cur][0]);
        }
        return memo[cur][parentStatus ? 1 : 0];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        friend = new List[N+1];
        for(int n = 1; n <= N; n++) {
            friend[n] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }
        memo = new int[N+1][];
        for(int n = 0; n <= N; n++) {
            memo[n] = new int[] {-1, -1};
        }
        int answer = search(1, 0, true);
        System.out.println(answer);
    }
}