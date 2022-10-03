import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] info;
    private List<Integer>[] children;
    private boolean[][] visited;
    private int maxSheepCnt = 0;

    private void search(int node, int vis, int sheepCnt, int wolfCnt) {
        if((vis & (1 << node)) == 0) {
            if(info[node] == 1) wolfCnt++;
            else sheepCnt++;
            vis |= (1 << node);
        }
        int diff = sheepCnt - wolfCnt;
        if(visited[node][vis]) return;
        visited[node][vis] = true;
        if(diff <= 0) return;
        maxSheepCnt = Math.max(maxSheepCnt, sheepCnt);

        for(int next : children[node]) {
            search(next, vis, sheepCnt, wolfCnt);
        }
    }

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        children = new List[info.length];
        visited = new boolean[info.length][(int) Math.pow(2, info.length)];
        for(int idx = 0; idx < info.length; idx++) {
            children[idx] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            children[edge[0]].add(edge[1]);
            children[edge[1]].add(edge[0]);
        }
        search(0, 0, 0, 0);
        int answer = maxSheepCnt;
        return answer;
    }
}