import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
	private ArrayList<Integer>[][][][] people;
	private HashMap<String, Integer> lang;
	private HashMap<String, Integer> job;
	private HashMap<String, Integer> career;
	private HashMap<String, Integer> food;
	
	// score 이상인 수의 개수 반환
	private int binarySearch(ArrayList<Integer> arr, int score) {
		if(arr.size() == 0) return 0;
		if(arr.get(arr.size()-1) < score) return 0;
		if(arr.get(0) >= score) return arr.size();
		int minIdx = 0;
		int maxIdx = arr.size() - 1;
		int curIdx = maxIdx / 2;
		while(true) {
			if(maxIdx - minIdx == 1) break;
			if(arr.get(curIdx) >= score) maxIdx = curIdx;
			else minIdx = curIdx;
			curIdx = minIdx + (maxIdx - minIdx) / 2;
		}
		return arr.size() - maxIdx;
	}
	
	// 사람 수 세서 리턴
	private int countPerson(String[] qr, int[] selArr, int idx) {
		if(idx == 4) {
			return binarySearch(people[selArr[0]][selArr[1]][selArr[2]][selArr[3]], Integer.parseInt(qr[4]));
		}
		int res = 0;
		if("-".equals(qr[idx])) {
			int cnt = 2;
			if(idx == 0) cnt = 3;
			for(int c = 0; c < cnt; c++) {
				selArr[idx] = c;
				res += countPerson(qr, selArr, idx + 1);
			}
		}
		else {
			if(idx == 0) selArr[idx] = lang.get(qr[idx]);
			else if(idx == 1) selArr[idx] = job.get(qr[idx]);
			else if(idx == 2) selArr[idx] = career.get(qr[idx]);
			else if(idx == 3) selArr[idx] = food.get(qr[idx]);
			res = countPerson(qr, selArr, idx + 1);
		}
		return res;
	}
	
    public int[] solution(String[] info, String[] query) {
    	people = new ArrayList[3][2][2][2];
    	// cpp, java, python
    	for(int l = 0; l < 3; l++) {
    		// backend, frontend
    		for(int j = 0; j < 2; j++) {
    			// junior, senior
    			for(int c = 0; c < 2; c++) {
    				// chicken, pizza
    				for(int f = 0; f < 2; f++) {
    					people[l][j][c][f] = new ArrayList();
    				}
    			}
    		}
    	}
    	
    	lang  = new HashMap() {{
    		put("cpp", 0);
    		put("java", 1);
    		put("python", 2);
    	}};
    	job  = new HashMap() {{
    		put("backend", 0);
    		put("frontend", 1);
    	}};
    	career  = new HashMap() {{
    		put("junior", 0);
    		put("senior", 1);
    	}};
    	food  = new HashMap() {{
    		put("chicken", 0);
    		put("pizza", 1);
    	}};
    	
    	StringTokenizer st;
    	for(String person : info) {
    		st = new StringTokenizer(person);
    		people[lang.get(st.nextToken())][job.get(st.nextToken())][career.get(st.nextToken())][food.get(st.nextToken())].add(Integer.parseInt(st.nextToken()));
    	}
    	
    	for(int l = 0; l < 3; l++) {
    		for(int j = 0; j < 2; j++) {
    			for(int c = 0; c < 2; c++) {
    				for(int f = 0; f < 2; f++) {
    					Collections.sort(people[l][j][c][f]);
    				}
    			}
    		}
    	}
    	
    	int[] answer = new int[query.length];
    	for(int q = 0; q < query.length; q++) {
    		answer[q] = countPerson(query[q].split(" and | "), new int[4], 0);
    	}
        return answer;
    }
}