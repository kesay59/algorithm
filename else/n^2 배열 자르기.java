import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int leftR = (int) (left / n);
        int leftC = (int) (left % n);
        int rightR = (int) (right / n);
        int rightC = (int) (right % n);
        List<Integer> arr = new ArrayList<>();
        if(leftR == rightR) {
            int r = leftR;
            for(int c = leftC; c <= rightC; c++) {
                arr.add(c <= r ? r + 1 : c + 1);
            }
        } else {
            for(int c = leftC; c < n; c++) {
                arr.add(c <= leftR ? leftR + 1 : c + 1);
            }
            for(int r = leftR + 1; r < rightR; r++) {
                for(int c = 0; c < n; c++) {
                    arr.add(c <= r ? r + 1 : c + 1);
                }
            }
            for(int c = 0; c <= rightC; c++) {
                arr.add(c <= rightR ? rightR + 1 : c + 1);
            }
        }
        int[] answer = new int[arr.size()];
        for(int idx = 0; idx < arr.size(); idx++) {
            answer[idx] = arr.get(idx);
        }
        return answer;
    }
}