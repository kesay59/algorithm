import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1967 {
    private static List<Integer>[] children;
    private static int[] values;
    private static int maxValue = 0;

    private static int getMaxValue(int idx) {
        if(children[idx].size() >= 2) {
            int[] lens = new int[children[idx].size()];
            for(int i = 0; i < children[idx].size(); i++) {
                lens[i] = getMaxValue(children[idx].get(i));
            }
            Arrays.sort(lens);
            maxValue = Math.max(maxValue, lens[lens.length-1] + lens[lens.length-2]);
            return lens[lens.length-1] + values[idx];
        } else if(children[idx].size() == 1) {
            return getMaxValue(children[idx].get(0)) + values[idx];
        }
        return values[idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        children = new List[N+1];
        values = new int[N+1];
        for(int n = 1; n <= N; n++) {
            children[n] = new ArrayList<>();
        }
        StringTokenizer st;
        int p, c, v;
        for(int n = 1; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            children[p].add(c);
            values[c] = v;
        }
        int res = getMaxValue(1);
        System.out.println(Math.max(res, maxValue));
    }

}
// 루트부터 재귀적으로 서브 트리로 내려가면서 반복
//
// - 자식이 2개 이상인 경우
// 자식들 중 가장 큰 두 값을 합한 값을 정답 후보와 비교 (최대값 갱신)
// 자식들 중 가장 큰 값에 자신의 값을 더해서 반환
// - 자식이 1개인 경우
// 자식 값에 자신의 값을 더해서 반환
// - 자식이 없는 경우
// 자신의 값을 반환
//
// 최종적으로 반환된 값과 정답 후보 중 큰 값을 출력