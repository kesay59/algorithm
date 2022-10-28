import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class BJ1036 {
    private static class Alp implements Comparable<Alp> {
        char ch;
        int num;
        int[] arr = new int[50];

        Alp(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }

        private BigInteger calculate(int num) {
            BigInteger answer = BigInteger.ZERO;
            BigInteger std = BigInteger.ONE;
            for(int idx = 0; idx < arr.length; idx++) {
                answer = answer.add(std.multiply(BigInteger.valueOf(arr[idx] * num)));
                std = std.multiply(BigInteger.valueOf(36));
            }
            return answer;
        }

        @Override
        public int compareTo(Alp o) {
            return (o.calculate(35).subtract(o.calculate(o.num)))
                    .subtract(this.calculate(35).subtract(this.calculate(this.num)))
                    .compareTo(BigInteger.ZERO);
        }
    }

    private static int convertCharToNum(char ch) {
        if(ch >= 'A') return ch - 55;
        return ch - 48;
    }

    private static char convertNumToChar(int num) {
        if(num < 10) return (char) (num + 48);
        return (char) (num + 55);
    }

    public static void main(String[] args) throws IOException {
        Alp[] alps = new Alp[36];
        for(int idx = 0; idx < 36; idx++) {
            alps[idx] = new Alp(convertNumToChar(idx), idx);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            String line = br.readLine();
            for(int idx = 0; idx < line.length(); idx++) {
                int num = convertCharToNum(line.charAt(idx));
                alps[num].arr[line.length() - idx - 1]++;
            }
        }
        Arrays.sort(alps);
        int K = Integer.parseInt(br.readLine());
        for(int k = 0, c = 0; k < K && c < alps.length; k++, c++) {
            if(alps[c].ch == 'Z') k--;
            alps[c].ch = 'Z';
        }
        BigInteger answer = BigInteger.ZERO;
        for(int k = 0; k < alps.length; k++) {
            answer = answer.add(alps[k].calculate(convertCharToNum(alps[k].ch)));
        }
        StringBuilder stb = new StringBuilder();
        if(answer.compareTo(BigInteger.ZERO) == 0) {
            stb.append(0);
        } else {
            while(answer.compareTo(BigInteger.ZERO) > 0) {
                stb.append(convertNumToChar(answer.remainder(BigInteger.valueOf(36)).intValue()));
                answer = answer.divide(BigInteger.valueOf(36));
            }
        }
        System.out.println(stb.reverse().toString());
    }
}