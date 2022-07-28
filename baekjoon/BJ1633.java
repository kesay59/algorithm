import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1633 {
	private static List<int[]> input;
	private static int[][][] memo;
	private static void selectTeam(int idx, int white, int black, int sum) {
		if(memo[idx][white][black] >= sum) return;
		memo[idx][white][black] = sum;
		if(idx == input.size() || (white == 0 && black == 0)) {
			return;
		}
		if(white > 0) {
			selectTeam(idx + 1, white - 1, black, sum + input.get(idx)[0]);
		}
		if(black > 0) {
			selectTeam(idx + 1, white, black - 1, sum + input.get(idx)[1]);
		}
		selectTeam(idx + 1, white, black, sum);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new ArrayList<>();
		StringTokenizer st;
		while(br.ready()) {
			st = new StringTokenizer(br.readLine());
			input.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		memo = new int[input.size() + 1][16][16];
		selectTeam(0, 15, 15, 1);
		int maxValue = 0;
		for(int i = 0; i < memo.length; i++) {
			maxValue = Math.max(maxValue, memo[i][0][0]);
		}
		System.out.println(maxValue - 1);
	}
}
