import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1636 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] cookies = new int[num][];
		StringTokenizer st;
		for(int n = 0; n < num; n++) {
			st = new StringTokenizer(br.readLine());
			cookies[n] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		int[][] memo = new int[num][201];
		for(int[] m : memo) {
			Arrays.fill(m, Integer.MAX_VALUE);
		}
		int bestStartStress = cookies[0][0];
		int bestDelta = Integer.MAX_VALUE;
		out : for(int startStress = cookies[0][0]; startStress <= cookies[0][1]; startStress++) {
			int stress = startStress;
			int delta = 0;
			for(int n = 1; n < num; n++) {
				if(stress < cookies[n][0]) {
					delta += cookies[n][0] - stress;
					stress = cookies[n][0];
				} else if(stress > cookies[n][1]) {
					delta += stress - cookies[n][1];
					stress = cookies[n][1];
				}
				if(memo[n][stress] <= delta) continue out;
				memo[n][stress] = delta;
			}
			if(delta < bestDelta) {
				bestDelta = delta;
				bestStartStress = startStress;
			}
		}
		System.out.println(bestDelta);
		System.out.println(bestStartStress);
		int stress = bestStartStress;
		for(int n = 1; n < num; n++) {
			if(stress < cookies[n][0]) {
				stress = cookies[n][0];
			} else if(stress > cookies[n][1]) {
				stress = cookies[n][1];
			}
			System.out.println(stress);
		}
	}
}
