import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Long>[] sumMap = new HashMap[num-1];
		sumMap[0] = new HashMap<Integer, Long>();
		sumMap[0].put(Integer.parseInt(st.nextToken()), (long)1);
		int cur, res;
		for(int n = 1; n < num - 1; n++) {
			sumMap[n] = new HashMap<Integer, Long>();
			cur = Integer.parseInt(st.nextToken());
			for(Entry<Integer, Long> pre : sumMap[n-1].entrySet()) {
				res = pre.getKey() + cur;
				if(res <= 20) sumMap[n].put(res, sumMap[n].containsKey(res) ? sumMap[n].get(res) + pre.getValue() : pre.getValue());
				res = pre.getKey() - cur;
				if(res >= 0) sumMap[n].put(res, sumMap[n].containsKey(res) ? sumMap[n].get(res) + pre.getValue() : pre.getValue());
			}
		}
		cur = Integer.parseInt(st.nextToken());
		System.out.println(sumMap[num-2].containsKey(cur) ? sumMap[num-2].get(cur) : 0);
	}
}
