// 2021 kakao blind recruitment
// 신규 아이디 추천

import java.util.Arrays;

class Solution {
    public String solution(String new_id) {
    	String answer = "";
    	int len = new_id.length();
    	char[] idChArr = new_id.toCharArray();
    	boolean[] isUseArr = new boolean[len];
    	Arrays.fill(isUseArr, true);
    	
    	for(int i = 0; i < len; i++) {
    		if(idChArr[i] >= 'A' && idChArr[i] <= 'Z') idChArr[i] += 32;
    		else if((idChArr[i] >= 'a' && idChArr[i] <= 'z') || 
    				(idChArr[i] >= '0' && idChArr[i] <= '9')  || 
    				idChArr[i] == '-' || 
    				idChArr[i] == '_' || 
    				idChArr[i] == '.') continue;
    		else isUseArr[i] = false;
    	}
    	
    	boolean flag = true;
    	for(int i = 0; i < len; i++) {
    		if(isUseArr[i]) {
    			if(idChArr[i] == '.') {
    				if(flag) isUseArr[i] = false;
    				else flag = true;
    			}
    			else flag = false;
    		}
    	}
    	for(int i = len - 1; i >= 0; i--) {
    		if(isUseArr[i]) {
    			if(idChArr[i] == '.') isUseArr[i] = false;
    			else break;
    		}
    	}
    	
    	
    	StringBuilder stb = new StringBuilder();
    	for(int i = 0; i < len; i++) {
    		if(isUseArr[i]) {
    			stb.append(idChArr[i]);
    		}
    		if(stb.length() == 15) {
    			if(stb.charAt(14) == '.') stb.deleteCharAt(14);
    			break;
    		}
    	}
    	if(stb.length() == 0) {
    		answer = "aaa";
    	}
    	else if(stb.length() <= 2) {
    		while(stb.length() != 3) {    			
    			stb.append(stb.charAt(stb.length()-1));
    		}
    		answer = stb.toString();
    	}
    	else {
    		answer = stb.toString();
    	}
    	
        return answer;
    }
}