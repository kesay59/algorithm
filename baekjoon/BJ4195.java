import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ4195 {
    private static void union(List<Integer> parent, List<Integer> group, int a, int b) {
        int ap = find(parent, a);
        int bp = find(parent, b);
        if(ap != bp) {
            group.set(ap, getGroupCnt(parent, group, a) + getGroupCnt(parent, group, b));
            parent.set(bp, ap);
        }
    }
    private static int getGroupCnt(List<Integer> parent, List<Integer> group, int num) {
        return group.get(find(parent, num));
    }
    private static int find(List<Integer> parent, int num) {
        if(parent.get(num) == num) return num;
        parent.set(num, find(parent, parent.get(num)));
        return parent.get(num);
    }
    private static void add(List<Integer> parent, List<Integer> group, HashMap<String, Integer> names, String name) {
        names.put(name, parent.size());
        parent.add(parent.size());
        group.add(1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            List<Integer> parent = new ArrayList<>();
            List<Integer> group = new ArrayList<>();
            HashMap<String, Integer> names = new HashMap<>();
            int F = Integer.parseInt(br.readLine());
            for(int f = 0; f < F; f++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] numbers = new int[2];
                for(int i = 0; i < 2; i++) {
                    String name = st.nextToken();
                    if(!names.containsKey(name)) add(parent, group, names, name);
                    numbers[i] = names.get(name);
                }
                union(parent, group, numbers[0], numbers[1]);
                answer.append(getGroupCnt(parent, group, numbers[0])).append('\n');
            }
        }
        System.out.println(answer.toString());
    }
}