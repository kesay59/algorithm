import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] front = new int[num];
		front[0] = 1;
		for(int i = 1; i < num; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i]) front[i] = Math.max(front[i], front[j] + 1);
			}
			if(front[i] == 0) front[i] = 1;
		}
		int[] back = new int[num];
		back[num-1] = 1;
		for(int i = num - 2; i >= 0; i--) {
			for(int j = i + 1; j < num; j++) {
				if(arr[j] < arr[i]) back[i] = Math.max(back[i], back[j] + 1);
			}
			if(back[i] == 0) back[i] = 1;
		}
		int max = 0;
		for(int i = 0; i < num; i++) {
			max = Math.max(max, front[i] + back[i]);
		}
		System.out.println(max - 1);
	}
}
