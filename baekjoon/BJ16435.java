import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16435 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int fruitCnt = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		int[] fruits = new int[fruitCnt];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < fruitCnt; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fruits);
		for(int i = 0; i < fruitCnt; i++) {
			if(fruits[i] <= snake) snake++;
			else break;
		}
		System.out.println(snake);
	}
}

//int low = 0, high = fruitCnt - 1, cur = high / 2, pre = cur;
//while(low < high) {
//	if(fruits[cur] <= snake + cur) {
//		low = cur;
//	}
//	else {
//		high = cur;
//	}
//	cur = low + (high - low + 1) / 2;
//	if(cur == pre) break;
//	else pre = cur;
//}
//System.out.println(snake + cur + (fruits[cur] <= snake + cur ? 1 : 0));