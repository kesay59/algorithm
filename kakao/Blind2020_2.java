import java.util.Deque;
import java.util.LinkedList;

class Solution {
       public String solution(String p) {
    	if(p.equals("")) return "";
    	char[] line = p.toCharArray();
    	Deque<Character> que= new LinkedList<>();
    	int bal = 0;
    	for(int i = 0; i < line.length; i++) {
    		que.addLast(line[i]);
    		if(line[i] == '(') bal++;
    		else bal--;
    		if(bal==0) {
    			String sub;
    			if(i+1 != line.length) sub = solution(p.substring(i + 1));
    			else sub = "";
    			
    			if(check(queToString(que))) {
    				return queToString(que)+sub;
    			} else {
    				que.pollFirst();
    				que.pollLast();
    				for(int q = 0; q < que.size(); q++) {
    					char ch = que.pollFirst();
    					if(ch == '(') que.addLast(')');
    					else que.addLast('(');
    				}
    				return "(" + sub + ")" + queToString(que);
    			}
    		}
    	}
        String answer = "";
        return answer;
    }

	private boolean check(String line) {
		int bal = 0;
		for(char ch : line.toCharArray()) {
			if(ch == ')') bal--;
			else bal++;
			if(bal < 0) return false;
		}
		return true;
	}
	
	private String queToString(Deque<Character> que) {
		StringBuilder stb = new StringBuilder();
		for(int i = 0; i < que.size(); i++) {
			char ch = que.pollFirst();
			stb.append(ch);
			que.offerLast(ch);
		}
		return stb.toString();
	}
}