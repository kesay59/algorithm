import java.io.*;
import java.util.*;

public class BJ1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        List<String> words = new ArrayList<>();
        for(int i = 1; i < word.length() - 1; i++) {
            for(int j = i + 1; j < word.length(); j++) {
                words.add(
                        new StringBuilder(word.substring(0, i)).reverse().toString()
                        + new StringBuilder(word.substring(i, j)).reverse().toString()
                        + new StringBuilder(word.substring(j, word.length())).reverse().toString()
                );
            }
        }
        Collections.sort(words);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(words.get(0));
        bw.flush();
        bw.close();
    }
}