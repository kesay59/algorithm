package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//baekjoon 14501 퇴사
public class BJ14501 {
	
	static int max = 0;
	
	static void select(int[][] arr, int len, int pre, int dp, int sum) {
		if(len <= dp) {
			if(len < dp) sum -= arr[pre][1];
			max = Math.max(max, sum);
			return;
		}
		for(int i = dp; i < len; i++) {
			select(arr, len, i, i + arr[i][0], sum + arr[i][1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[][] arr = new int[len][2];
		StringTokenizer st;
		for(int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		select(arr, len, 0, 0, 0);
		System.out.println(max);
	}

}
