import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
        public int[] solution(String[] gems) {
        Set<String> gemNameSet = new HashSet<String>();
        for(String gem : gems) gemNameSet.add(gem);
        int gemCnt = gemNameSet.size();

        int[] answer = {1, gems.length};
        Map<String, Integer> gemSelectMap = new HashMap<String, Integer>();
        int fIdx = 0, bIdx = 0;
        while(bIdx < gems.length) {
        	while(gemSelectMap.size() != gemCnt) {
        		if(gemSelectMap.containsKey(gems[bIdx])) gemSelectMap.put(gems[bIdx], gemSelectMap.get(gems[bIdx]) + 1);
        		else gemSelectMap.put(gems[bIdx], 1);
        		if(++bIdx == gems.length) break;
        	}
        	while(gemSelectMap.size() == gemCnt) {
        		gemSelectMap.put(gems[fIdx], gemSelectMap.get(gems[fIdx])-1);
        		if(gemSelectMap.get(gems[fIdx++]) == 0) {
        			gemSelectMap.remove(gems[fIdx-1]);
        			if(answer[1] - answer[0] > bIdx - fIdx) answer = new int[]{fIdx, bIdx};
        			break;
        		}
        	}
        }
        return answer;
    }
}