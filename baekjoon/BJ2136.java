import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2136 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][];
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		int ant;
		for(int n = 0; n < N; n++) {
			ant = Integer.parseInt(br.readLine());
			arr[n] = new int[] {Math.abs(ant), n};
			if(ant < 0) leftList.add(ant);
			else rightList.add(ant);
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Collections.sort(leftList);
		Collections.sort(rightList);
		int left = leftList.isEmpty() ? 0 : Math.abs(leftList.get(0));
		int right = rightList.isEmpty() ? 0 : L - rightList.get(0);
		if(left > right) {
			System.out.println((arr[leftList.size()-1][1] + 1) + " " + left);
		} else {
			System.out.println((arr[leftList.size()][1] + 1) + " " + right);
		}
	}
}
