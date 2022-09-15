import java.util.Arrays;

class Solution {
	private int arrowNum;
	private int[] info;
	private int maxScoreDiff = 0;
	private int[] maxTargetList = new int[11];
	
	private int calculateScoreDiff(int[] targetList) {
		int lion = 0;
		int peach = 0;
		for(int idx = 0; idx < 11; idx++) {
			if(info[idx] != 0 || targetList[idx] != 0) {
				int score = 10 - idx;
				if(info[idx] < targetList[idx]) lion += score;
				else peach += score;				
			}
		}
		return lion - peach;
	}
	
	private void shootArrow(int[] targetList, int targetIdx, int arrowCnt) {
		if(arrowCnt >= arrowNum) {
			int scoreDiff = calculateScoreDiff(targetList);
			if(scoreDiff > maxScoreDiff) {
				maxScoreDiff = scoreDiff;
				maxTargetList = targetList.clone();
			}
			else if(scoreDiff == maxScoreDiff) {
				for(int idx = 10; idx >= 0; idx--) {
					if(maxTargetList[idx] < targetList[idx]) {
						maxTargetList = targetList.clone();
						break;
					}
					else if(maxTargetList[idx] > targetList[idx]) {
						break;
					}
				}
			}
			return;
		}
		
		for(int idx = targetIdx; idx < 11; idx++) {
			if(targetList[idx] <= info[idx]) {
				targetList[idx]++;
				shootArrow(targetList, idx, arrowCnt + 1);
				targetList[idx]--;				
			}
		}
	}
	
    public int[] solution(int n, int[] info) {
    	arrowNum = n;
    	this.info = info;
    	shootArrow(new int[11], 0, 0);
        int[] answer = maxTargetList;
        return maxScoreDiff > 0 ? answer : new int[] {-1};
    }
}