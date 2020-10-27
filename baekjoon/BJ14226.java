import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//BJ 14226 이모티콘
public class BJ14226 {
	//곱뛸때는 1+곱 내가 수정할 수 있는 동안 아래로 쭉 내리면서 갱신 수정 불가 뜨면 break
	public static void main(String[] args) throws IOException {
		int len = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] memo = new int[len + len];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[1] = 0;
		for(int i = 1; i < len; i++) {
			int val = i;
			int dp = 0;
			while(val < len) {
				val += i;
				int cur = memo[i] + 1 + ++dp;
				if(memo[val] > cur) {
					memo[val] = cur;
					int sub_dp = cur;
					for(int v = val - 1; v > 0; v--) {
						if(memo[v] > ++sub_dp) memo[v] = sub_dp;
						else break;
					}
				}
			}
		}
		System.out.println(memo[len]);
	}

}
