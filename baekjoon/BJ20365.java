import java.io.*;

public class BJ20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int cntB = 0;
        int cntR = 0;
        char ch = 'N';
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != ch) {
                ch = arr[i];
                if(ch == 'B') {
                    cntB++;
                } else {
                    cntR++;
                }
            }
        }
        System.out.println(Math.min(cntB, cntR) + 1);
    }
}