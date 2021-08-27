import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {

    private boolean[][] personFoodList;
    private HashMap<String, ArrayList<Integer>>[] courseList;

    private void makeCourse(int[] selList, int selIdx, int preAlp) {
        if(selIdx >= selList.length) return;

        StringBuilder stb = new StringBuilder();
        stb.append("k");
        for(int i = 1; i < selIdx; i++) {
            stb.append((char)(selList[i] + 'A'));
        }
        ArrayList<Integer> preSelPersonList = courseList[selIdx - 1].get(stb.toString());
        for(int i = preAlp + 1; i < 26; i++) {
            ArrayList<Integer> selPersonList = new ArrayList<Integer>();
            for(int p : preSelPersonList) {
                if(personFoodList[p][i]) selPersonList.add(p);
            }
            if(selPersonList.size() > 1) {
                selList[selIdx] = i;
                courseList[selIdx].put(stb.toString() + ((char)(i + 'A')), selPersonList);
                makeCourse(selList, selIdx + 1, i);
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        personFoodList = new boolean[orders.length][26];
        for(int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            for(char ch : order) {              
                personFoodList[i][ch - 'A'] = true;
            }
        }

        courseList = new HashMap[course[course.length-1] + 1];
        for(int i = 0; i < courseList.length; i++) {
            courseList[i] = new HashMap<String, ArrayList<Integer>>();
        }
        ArrayList<Integer> baseList = new ArrayList<Integer>();
        for(int i = 0; i < orders.length; i++) baseList.add(i);
        courseList[0].put("k", baseList);

        makeCourse(new int[courseList.length], 1, -1); 

        ArrayList<String> ans = new ArrayList<String>();
        for(int cs : course) {
            int maxCnt = 0;
            for(String key : courseList[cs].keySet()) {
                maxCnt = Math.max(maxCnt, courseList[cs].get(key).size());
            }
            for(String key : courseList[cs].keySet()) {
                if(courseList[cs].get(key).size() == maxCnt) ans.add(key.substring(1));
            }
        }
        Collections.sort(ans);

        String[] answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}