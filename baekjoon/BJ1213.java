import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] count = new int['Z' + 1];
        for(char ch : chars) {
            count[ch]++;
        }
        char odd = 0;
        for(int i = 'A'; i <= 'Z'; i++) {
            if(count[i] % 2 == 1) {
                if(odd == 0) {
                    odd = (char) i;
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
            }
        }
        StringBuilder stb = new StringBuilder();
        for(int i = 'A'; i <= 'Z'; i++) {
            for(int c = 0; c < count[i] / 2; c++) {
                stb.append((char)i);
            }
        }
        if(odd != 0) stb.append(odd);
        for(int i = 'Z'; i >= 'A'; i--) {
            for(int c = 0; c < count[i] / 2; c++) {
                stb.append((char)i);
            }
        }
        System.out.println(stb.toString());
    }
}