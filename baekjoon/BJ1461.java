import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> minusList = new ArrayList<>();
		List<Integer> plusList = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int tmp;
		for(int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if(tmp > 0) plusList.add(tmp);
			else minusList.add(tmp);
		}
		Collections.sort(minusList);
		Collections.sort(plusList);
		int sum = 0;
		for(int i = plusList.size() - 1; i >= 0; i-=M) {
			sum += plusList.get(i) * 2;
		}
		for(int i = 0; i < minusList.size(); i+=M) {
			sum -= minusList.get(i) * 2;
		}
		if(minusList.size() == 0) {
			sum -= plusList.get(plusList.size()-1);
		} else if(plusList.size() == 0) {
			sum += minusList.get(0);
		} else if(Math.abs(minusList.get(0)) < Math.abs(plusList.get(plusList.size()-1))) {
			sum -= plusList.get(plusList.size()-1);
		} else {
			sum += minusList.get(0);
		}
		System.out.println(sum);
	}
}
