import java.io.*;

public class BJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int n = 0; n < N; n++) {
            char[] arr = br.readLine().toCharArray();
            int sum = 0;
            int cur = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 'O') {
                    cur++;
                    sum += cur;
                } else {
                    cur = 0;
                }
            }
            answer.append(sum).append('\n');
        }
        System.out.print(answer.toString());
    }
}
