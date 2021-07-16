import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ20055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[len * 2];
		boolean[] robot = new boolean[len];
		for(int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int cur = 0;
		int cnt = 0;
		int tm = 0;
		while(cnt < lim) {
			tm++;
			cur = (cur + arr.length - 1) % arr.length;
			robot[len - 1] = false;
			for(int i = len - 2; i >= 0; i--) {
				if(robot[i] && !robot[i + 1]) {
					robot[i + 1] = true;
					robot[i] = false;
				}
			}
			robot[len - 1] = false;
			for(int i = len - 2; i >= 0; i--) {
				if(robot[i] && !robot[i + 1]) {
					if(arr[(cur + i + 1) % arr.length] > 0) {
						robot[i] = false;
						robot[i + 1] = true;
						if(--arr[(cur + i + 1) % arr.length] == 0) cnt++;
					}
				}
			}
			if(!robot[0]) {
				if(arr[cur] > 0) {
					robot[0] = true;
					if(--arr[cur] == 0) cnt++;
				}
			}
		}
		System.out.println(tm);
	}
}
