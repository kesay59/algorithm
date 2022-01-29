import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<int[]> lineList = new ArrayList<int[]>();
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			lineList.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		Collections.sort(lineList, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
		});
		int[] cntList = new int[num];
		for(int i = 0; i < num; i++) {
			int cnt = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(lineList.get(j)[1] < lineList.get(i)[1]) {
					cnt = Math.max(cnt, cntList[j]);
				}
			}
			cntList[i] = cnt + 1;
		}
		int max = 0;
		for(int cnt : cntList) {
			max = Math.max(max, cnt);
		}
		System.out.println(num - max);
	}
}
