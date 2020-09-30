import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//BJ 1562 계단 수
public class BJ1562{ 
	static int as = 1;
	static int[][][] memo; //자리수, 직전수, 마스킹
	final static int MOD = 1000000000;
	
	static int twist(int idx, int pre, int ck) {
		if(idx < 1) {
			if(ck != as) return 0;
			return 1;
		}
		if(memo[idx][pre][ck] == -1) {
			int sum = 0;
			if(pre - 1 >= 0) sum += twist(idx - 1, pre-1, (ck | (1 << (pre-1))));
			if(pre + 1 < 10) sum += twist(idx - 1, pre+1, (ck | (1 << (pre+1))));
			memo[idx][pre][ck] = sum % MOD;
		}
		return memo[idx][pre][ck];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		memo = new int[len][10][1024];
		for(int i = 0; i < len; i++) 
			for(int j = 0; j < 10; j++)
				Arrays.fill(memo[i][j], -1);
		as = (as << 10) - 1;
		int cnt = 0;
		for(int i = 1; i < 10; i++) {
			cnt += twist(len - 1, i, 1 << i);
			cnt %= MOD;
		}
		System.out.println(cnt);
	}

}
