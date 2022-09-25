import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stk = new Stack<>();
        for(int l = 0; l < s.length(); l++) {
            if(!stk.isEmpty() && stk.peek() == s.charAt(l)) stk.pop();
            else stk.push(s.charAt(l));
        }
        return stk.isEmpty() ? 1 : 0;
    }
}