import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report_list, int k) {
    	HashMap<String, Integer> usrIdxMap = new HashMap<String, Integer>();
    	for(int idx = 0; idx < id_list.length; idx++) {
    		usrIdxMap.put(id_list[idx], idx);
    	}
    	
    	HashMap<String, HashSet<String>> reportedUsrMap = new HashMap<String, HashSet<String>>();
    	for(String id : id_list) {
    		reportedUsrMap.put(id, new HashSet<String>());
    	}
    	
    	StringTokenizer st;
    	String from, to;
    	for(String report : report_list) {
    		st = new StringTokenizer(report);
    		from = st.nextToken();
    		to = st.nextToken();
    		reportedUsrMap.get(to).add(from);
    	}
    	
        int[] answer = new int[id_list.length];
        HashSet<String> reportingUsrSet;
        for(String reportedUsr : reportedUsrMap.keySet()) {
        	reportingUsrSet = reportedUsrMap.get(reportedUsr);
        	if(reportingUsrSet.size() >= k) {
        		for(String reportingUsr : reportingUsrSet) {
        			answer[usrIdxMap.get(reportingUsr)]++;
        		}
        	}
        }
        return answer;
    }
}