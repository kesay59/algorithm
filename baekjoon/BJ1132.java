import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1132 {
    private static class Alp implements Comparable<Alp> {
        char ch;
        boolean isFirst = false;
        int[] arr = new int[12];

        Alp(char ch) {
            this.ch = ch;
        }

        @Override
        public int compareTo(Alp o) {
            for(int i = 11; i >= 0; i--) {
                if(this.arr[i] != o.arr[i]) return this.arr[i] - o.arr[i];
            }
            return 0;
        }

        public long sum(int num) {
            long s = 0;
            for(int i = 11; i >= 0; i--) {
                s += num * Math.pow(10, i) * arr[i];
            }
            return s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Alp[] alps = new Alp[10];
        for(int idx = 0; idx < 10; idx++) {
            alps[idx] = new Alp((char) (idx + 'A'));
        }
        boolean[] isUsed = new boolean[10];
        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            String line = br.readLine();
            alps[line.charAt(0) - 'A'].isFirst = true;
            for(int i = 1; i <= line.length(); i++) {
                Alp alp = alps[line.charAt(i-1) - 'A'];
                alp.arr[line.length() - i]++;
                isUsed[line.charAt(i-1) - 'A'] = true;
            }
        }
        int cnt = 10;
        List<Alp> alpList = new ArrayList<>();
        for(int idx = 0; idx < isUsed.length; idx++) {
            if(isUsed[idx]) {
                cnt--;
                alpList.add(alps[idx]);
            }
        }
        for(int idx = 0; idx < alpList.size(); idx++) {
            for(int i = 0; i < 11; i++) {
                if(alpList.get(idx).arr[i] >= 10) {
                    alpList.get(idx).arr[i + 1] += alpList.get(idx).arr[i] / 10;
                    alpList.get(idx).arr[i] %= 10;
                }
            }
        }
        Collections.sort(alpList);
        if(alpList.size() == 10) {
            if(alpList.get(0).isFirst) {
                for(int idx = 1; idx < 10; idx++) {
                    if(!alpList.get(idx).isFirst) {
                        Alp tmp = alpList.get(idx);
                        alpList.remove(tmp);
                        alpList.add(0, tmp);
                        break;
                    }
                }
            }
        }
        long answer = 0;
        for(Alp alp : alpList) {
            answer += alp.sum(cnt++);
        }
        System.out.println(answer);
    }
}