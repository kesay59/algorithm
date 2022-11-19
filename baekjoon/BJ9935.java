import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        IntStream stream = br.readLine().chars();
        String word = br.readLine();
        stream.forEach(ch -> {
            stk.push(ch);
            if(stk.peek() == word.charAt(word.length()-1) && stk.size() >= word.length()) {
                int i = word.length() - 1;
                for(; i >= 0; i--) {
                    tmp.push(stk.pop());
                    if(tmp.peek() != word.charAt(i)) {
                        break;
                    }
                }
                if(i == -1) {
                    tmp.clear();
                } else {
                    while(!tmp.isEmpty()) {
                        stk.push(tmp.pop());
                    }
                }
            }
        });
        StringBuilder stb = new StringBuilder();
        stk.stream().forEach(ch -> stb.append((char) ch.intValue()));
        System.out.println(stb.length() == 0 ? "FRULA" : stb.toString());
    }
}