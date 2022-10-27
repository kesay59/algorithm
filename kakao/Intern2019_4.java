import java.util.HashSet;

class Solution {
    private HashSet<Integer> banned = new HashSet<>();
    private void ban(boolean[][] bans, int idx, int mask) {
        if(idx >= bans.length) {
            banned.add(mask);
            return;
        }
        for(int u = 0; u < bans[idx].length; u++) {
            if(bans[idx][u]) {
                if((mask&(1<<u)) == 0) {
                    ban(bans, idx+1, mask|(1<<u));
                }
            }
        }
    }
    public int solution(String[] user_id, String[] banned_id) {
        boolean[][] bans = new boolean[banned_id.length][user_id.length];
        for(int b = 0; b < banned_id.length; b++) {
            String pattern = banned_id[b].replaceAll("\\*", ".");
            for(int u = 0; u < user_id.length; u++) {
                if(user_id[u].matches(pattern)) {
                    bans[b][u] = true;
                }
            }
        }
        ban(bans, 0, 0);
        int answer = banned.size();
        return answer;
    }
}