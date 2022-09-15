import java.util.*;

class Solution {
	private boolean checkPrimeNumber(Long num) {
		if(num == 1) return false;
		if(num == 2) return true;
		int sqrNum = (int)Math.ceil(Math.sqrt(num));
		for(int n = 2; n <= sqrNum; n++) {
			if(num % n == 0) return false; 
		}
		return true;
	}
	
    public int solution(int n, int k) {
    	StringBuilder stb = new StringBuilder();
    	while(n > 0) {
    		stb.append(n % k);
    		n /= k;
    	}
    	String[] numStrList = stb.reverse().toString().split("[0]+");
    	
    	int answer = 0;
    	for(String numStr : numStrList) {
    		if(checkPrimeNumber(Long.parseLong(numStr))) answer++;
    	}
        return answer;
    }
}