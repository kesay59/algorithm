import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] failRate = new double[N+1];
        Arrays.sort(stages);
        int userCnt = stages.length;
        int failUserCnt = 0;
        int stage = 1;
        for(int user = 0; user < stages.length; user++) {
            if(stages[user] != stage) {
                failRate[stage] = (double)failUserCnt / userCnt;
                userCnt -= failUserCnt;
                failUserCnt = 0;
                while(++stage != stages[user]);
            }
            failUserCnt++;
            if(stage > N) break;
        }
        if(stage <= N) failRate[stage] = failUserCnt / userCnt;
        
        failRate[0] = -1;
        int[] answer = new int[N];
        for(int n = 1; n <= N; n++) {
            int maxIdx = 0;
            for(int f = 1; f < failRate.length; f++) {
                if(failRate[maxIdx] < failRate[f]) maxIdx = f;
            }
            failRate[maxIdx] = -1;
            answer[n-1] = maxIdx;
        }         
        return answer;
    }
}