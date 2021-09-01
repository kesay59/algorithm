import java.util.Arrays;

class Solution {

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] distList = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(distList[i], Integer.MAX_VALUE);
            distList[i][i] = 0;
        }
        for(int[] fare : fares) {
            distList[fare[0]-1][fare[1]-1] = fare[2];
            distList[fare[1]-1][fare[0]-1] = fare[2];
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(distList[i][k] == Integer.MAX_VALUE || distList[k][j] == Integer.MAX_VALUE ) continue;
                    distList[i][j] = Math.min(distList[i][j], distList[i][k] + distList[k][j]);
                }
            }
        }

        int minFare = Integer.MAX_VALUE;
        for(int k = 0; k < n; k++) {
            minFare = Math.min(minFare, distList[s-1][k] + distList[k][a-1] + distList[k][b-1]);
        }

        int answer = minFare;
        return answer;
    }

}