import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[][] recordList = new String[record.length][];
        for(int r = 0; r < record.length; r++) {
            recordList[r] = record[r].split(" ");
        }

        Map<String, String> nicknameMap = new HashMap<String, String>();
        for(int r = recordList.length - 1; r >= 0; r--) {
            if(!"Leave".equals(recordList[r][0])) {
                if(!nicknameMap.containsKey(recordList[r][1])) nicknameMap.put(recordList[r][1], recordList[r][2]);
            }
        }

        List<String> answerList = new ArrayList<String>();
        StringBuilder stb;
        for(int r = 0; r < record.length; r++) {
            if(!"Change".equals(recordList[r][0])) {                
                stb = new StringBuilder();
                stb.append(nicknameMap.get(recordList[r][1])).append("님이 ");
                if("Leave".equals(recordList[r][0])) stb.append("나갔습니다.");
                else stb.append("들어왔습니다.");
                answerList.add(stb.toString());
            }
        }

        String[] answer = new String[answerList.size()];
        for(int a = 0; a < answerList.size(); a++) {
            answer[a] = answerList.get(a);
        }
        return answer;
    }
}