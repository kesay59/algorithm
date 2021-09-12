import java.util.ArrayList;
import java.util.List;
class Solution {
    public String solution(int[] numbers, String hand) {
    	List<int[]> btnLocs = new ArrayList<int[]>();
    	btnLocs.add(new int[] {3, 1});
    	int btn = 1;
    	for(int r = 0; r < 3; r++) {
    		for(int c = 0; c < 3; c++) {
    			btnLocs.add(new int[] {r, c});
    		}
    	}
    	
    	int[] left = new int[] {3, 0};
    	int[] right = new int[] {3, 2};
    	
    	StringBuilder ans_stb = new StringBuilder();
		boolean isLeft = false;
    	for(int number : numbers) {
    		if(number == 0 || number % 3 == 2) { //2, 5, 8, 0
    			int dr = Math.abs(right[0] - btnLocs.get(number)[0]) + Math.abs(right[1] - btnLocs.get(number)[1]);
    			int dl = Math.abs(left[0] - btnLocs.get(number)[0]) + Math.abs(left[1] - btnLocs.get(number)[1]);
    			if(dr > dl) isLeft = true;
    			else if(dr < dl) isLeft = false;
    			else isLeft = "left".equals(hand) ? true : false;
    		}
    		else if(number % 3 == 1) { //1, 4, 7
    			isLeft = true;
    		}
    		else { //3, 6, 9
    			isLeft = false;
    		}
    		
    		if(isLeft) {
    			ans_stb.append('L');
    			left[0] = btnLocs.get(number)[0];
    			left[1] = btnLocs.get(number)[1];
    		}
    		else {
    			ans_stb.append('R');
    			right[0] = btnLocs.get(number)[0];
    			right[1] = btnLocs.get(number)[1];
    		}
    	}
    	
        String answer = new String(ans_stb);
        return answer;
    }
}