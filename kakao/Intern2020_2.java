import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public long solution(String expression) {
        long[][] prioritySign = new long[][] {{'-', '-', '*', '*', '+', '+'}, {'*', '+', '-', '+', '-', '*'}, {'+', '*', '+', '-', '*', '-'}};

        String[] numbers = expression.split("[-|*|+]");
        String[] signs = expression.split("[0-9]+");

        long answer = 0; 

        Deque<Long>[] dq = new LinkedList[6];
        for(int i = 0; i < 6; i++) {
            dq[i] = new LinkedList<Long>();
            dq[i].offerLast(Long.parseLong(numbers[0]));
            for(int j = 1; j < numbers.length; j++) {
                dq[i].offerLast((long)(signs[j].charAt(0)));
                dq[i].offerLast(Long.parseLong(numbers[j]));;
            }
            dq[i].offerLast((long)1000);

            int priority = 0;
            while(dq[i].size() != 2) {
                long num = dq[i].pollFirst();
                long sig = dq[i].pollFirst();
                if(sig == prioritySign[priority][i]) {
                    if(sig == '-') num -= dq[i].pollFirst();
                    else if(sig == '+') num += dq[i].pollFirst();
                    else num *= dq[i].pollFirst();
                    dq[i].offerFirst(num);
                } else {
                    dq[i].offerLast(num);
                    dq[i].offerLast(sig);
                    if(sig == 1000) priority++;
                }
            }

            answer = Math.max(answer, Math.abs(dq[i].pollFirst()));
        }
        return answer;
    }
}