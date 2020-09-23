import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 11726 2xn 타일링
public class P11726 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num < 3) {
			System.out.println(num);
			System.exit(0);
		}
		int ppre = 0;
		int pre = 1;
		int cur = 2;
		int[] arr = new int[3];
		arr[0]=1;
		arr[1]=2;
		for(int i = 2; i < num; i++) {
			arr[cur] = arr[ppre] + arr[pre];
			ppre = pre;
			pre = cur;
			cur = (cur + 1) % 3;
		}
		System.out.println(arr[pre]);		
	}

}
