import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1991 {
    private static List<Character>[] children;

    private static StringBuilder preOrder = new StringBuilder();
    private static StringBuilder inOrder = new StringBuilder();
    private static StringBuilder postOrder = new StringBuilder();

    private static void search(char cur) {
        preOrder.append(cur);
        if(children[cur].get(0) != '.') search(children[cur].get(0));
        inOrder.append(cur);
        if(children[cur].get(1) != '.') search(children[cur].get(1));
        postOrder.append(cur);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        children = new List['A' + N];
        for(int n = 0; n < N; n++) {
            children['A' + n] = new ArrayList<>();
        }
        char p, c1, c2;
        StringTokenizer st;
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            p = st.nextToken().charAt(0);
            c1 = st.nextToken().charAt(0);
            c2 = st.nextToken().charAt(0);
            children[p].add(c1);
            children[p].add(c2);
        }
        search('A');
        System.out.println(preOrder.toString());
        System.out.println(inOrder.toString());
        System.out.println(postOrder.toString());
    }

}
