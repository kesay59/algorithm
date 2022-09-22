class Solution {
    public int solution(String s) {
        char[] s_charr = s.toCharArray();
        StringBuilder ans_stb = new StringBuilder();
        for(int idx = 0; idx < s_charr.length; idx++) {
        	if(s_charr[idx] >= '0' && s_charr[idx] <= '9') {
        		ans_stb.append(s_charr[idx]);
        	}
        	else {
        		if(s_charr[idx] == 'z') {
        			ans_stb.append('0');
        			idx += 3;
        		}
        		else if(s_charr[idx] == 'o') {
        			ans_stb.append('1');
        			idx += 2;
        		}
        		else if(s_charr[idx] == 't') {
        			if(s_charr[idx + 1] == 'w') {
            			ans_stb.append('2');
            			idx += 2;
        			}
        			else {
            			ans_stb.append('3');
            			idx += 4;
        			}
        		}
        		else if(s_charr[idx] == 'f') {
        			if(s_charr[idx + 1] == 'o') {
            			ans_stb.append('4');
            			idx += 3;
        			}
        			else {
            			ans_stb.append('5');
            			idx += 3;
        			}
        		}
        		else if(s_charr[idx] == 's') {
        			if(s_charr[idx + 1] == 'i') {
            			ans_stb.append('6');
            			idx += 2;
        			}
        			else {
            			ans_stb.append('7');
            			idx += 4;
        			}
        		}
        		else if(s_charr[idx] == 'e') {
        			ans_stb.append('8');
        			idx += 4;
        		}
        		else if(s_charr[idx] == 'n') {
        			ans_stb.append('9');
        			idx += 3;
        		}
        	}
        }
        int answer = Integer.parseInt(new String(ans_stb));
        return answer;
    }
}