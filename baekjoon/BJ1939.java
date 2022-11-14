import java.io.*;
import java.util.*;

public class BJ1939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer>[] bridges = new HashMap[N+1];
        for(int n = 1; n <= N; n++) {
            bridges[n] = new HashMap<>();
        }
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(!bridges[A].containsKey(B) || bridges[A].get(B) < C) {
                bridges[A].put(B, C);
                bridges[B].put(A, C);
            }
        }
        int[] weight = new int[N+1];
        boolean[] vis = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        int sta = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        weight[sta] = 1000000000;
        vis[sta] = true;
        bridges[sta].entrySet().stream().forEach(bridge -> weight[bridge.getKey()] = bridge.getValue());
        for(int n = 2; n <= N; n++) {
            int node = 0;
            for(int idx = 1; idx <= N; idx++) {
                if(!vis[idx] && weight[idx] >= weight[node]) {
                    node = idx;
                }
            }
            vis[node] = true;
            for(Map.Entry<Integer, Integer> bridge : bridges[node].entrySet()) {
                if(weight[bridge.getKey()] < Math.min(weight[node], bridge.getValue())) {
                    weight[bridge.getKey()] = Math.min(weight[node], bridge.getValue());
                }
            }
        }
        System.out.println(weight[end]);
    }
}