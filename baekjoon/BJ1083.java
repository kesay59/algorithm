import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> linkedList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedList::new));
        int S = Integer.parseInt(br.readLine());
        for(int i = 0; i < linkedList.size(); i++) {
            int maxIdx = i;
            for(int j = i + 1, cnt = 1; j < linkedList.size() && cnt <= S; j++, cnt++) {
                if(linkedList.get(j) > linkedList.get(maxIdx)) {
                    maxIdx = j;
                }
            }
            S -= maxIdx - i;
            linkedList.add(i, linkedList.get(maxIdx));
            linkedList.remove(maxIdx+1);
        }
        StringBuilder stb = new StringBuilder();
        linkedList.stream().forEach(it -> stb.append(it).append(' '));
        System.out.println(stb.toString());
    }
}