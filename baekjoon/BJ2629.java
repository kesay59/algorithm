import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[N * 500 + 1];
        for(int n = 0; n < N; n++) {
            int num = Integer.parseInt(st.nextToken());
            Stack<Integer> stk = new Stack<>();
            stk.push(num);
            for(int a = 0; a < arr.length; a++) {
                if(arr[a]) {
                    stk.push(a + num);
                    stk.push(Math.abs(a - num));
                }
            }
            while(!stk.isEmpty()) {
                arr[stk.pop()] = true;
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int m = 0; m < M; m++) {
            int num = Integer.parseInt(st.nextToken());
            stb.append(num >= arr.length ? "N " : (arr[num] ? "Y " : "N "));
        }
        System.out.println(stb.toString());
    }

}