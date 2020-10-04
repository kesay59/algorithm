import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//BJ 1744 수 묶기
public class BJ1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		for(int i = 0; i < len; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int sum = 0;
		int tmp = 0;
		boolean flag = false;
		int b = len - 1;
		while(b >= 0 && arr[b] > 1) {
			if(!flag) {
				tmp = arr[b--];
				flag = true;
			} else {
				sum += arr[b--] * tmp;
				flag = false;
			}
		}
		if(flag) sum += tmp;
		
		boolean zero = false;
		while(b >= 0 && arr[b] >= 0) {
			if(!zero) {
				if(arr[b] == 0) zero = true;
				sum += arr[b];
			}
			b--;
		}
		
		flag = false;
		int f = 0;
		while(f <= b) {
			if(!flag) {
				tmp = arr[f++];
				flag = true;
			} else {
				sum += arr[f++] * tmp;
				flag = false;
			}
		}
		if(flag) 
			if(!zero) sum += tmp;
		
		System.out.println(sum);
		
	}

}
