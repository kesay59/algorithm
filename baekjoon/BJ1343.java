import java.io.*;

public class BJ1343 {
    public static void main(String[] args) throws IOException {
        char[] charArray = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        for(char ch : charArray) {
            if(ch == 'X') {
                cnt++;
                if(cnt == 4) {
                    answer.append("AAAA");
                    cnt = 0;
                }
            } else {
                if(cnt == 2) {
                    answer.append("BB");
                    cnt = 0;
                } else if(cnt != 0) {
                    break;
                }
                answer.append('.');
            }
        }
        if(cnt == 4) {
            answer.append("AAAA");
        } else if(cnt == 2) {
            answer.append("BB");
        } else if(cnt != 0) {
            answer = new StringBuilder();
            answer.append(-1);
        }
        System.out.println(answer.toString());
    }
}