import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9498 {
    public static void main(String[] args) throws IOException {
        int score = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if(score >= 90) System.out.println('A');
        else if(score >= 80) System.out.println('B');
        else if(score >= 70) System.out.println('C');
        else if(score >= 60) System.out.println('D');
        else System.out.println('F');
    }
}