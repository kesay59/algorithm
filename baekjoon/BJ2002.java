import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ2002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Map<String, Integer> order = new HashMap<>();
		for(int n = 0; n < num; n++) {
			order.put(br.readLine(), n);
		}
		int idx = 0;
		int cnt = 0;
		boolean[] isGone = new boolean[num];
		for(int n = 0; n < num; n++) {
			String car = br.readLine();
			if(order.get(car) != idx) {
				cnt++;
				isGone[order.get(car)] = true;
			} else {
				isGone[order.get(car)] = true;
				for(; idx < num; idx++) {
					if(!isGone[idx]) break;
				}
			}
		}
		System.out.println(cnt);
	}
}
