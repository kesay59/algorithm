import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

//BJ 1149 RGB거리
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[num][3];
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(new Solution().solution(arr, num));
	}
}


class Solution{
	int solution(int[][] arr, int num) {
		int[] cost = new int[3];
		int[] cost_pre = new int[3];
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < 3; j++) {
				cost[j] = Integer.MAX_VALUE;
				for(int k = 0; k < 3; k++) {
					if(k == j) continue;
					else if(cost[j] > cost_pre[k] + arr[i][j]) cost[j] = cost_pre[k] + arr[i][j];
				}
			}
			for(int j = 0; j < 3; j++)
				cost_pre[j] = cost[j];
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0 ; i< 3; i++)
			if(answer > cost[i]) answer = cost[i]; 
		return answer;
	}
}