import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1253 {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		HashSet<Integer> goodNumSet = new HashSet<Integer>();
		int[] arr = new int[cnt];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		for(int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i = 0; i < cnt ; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] == 0) {
					if(j > 0 && arr[j] == arr[j-1]) goodNumSet.add(arr[i] + arr[j]);
				} else if(arr[j] == 0) {
					if(i > 0 && arr[i] == arr[i-1]) goodNumSet.add(arr[i] + arr[j]);
				} else {					
					goodNumSet.add(arr[i] + arr[j]);
				}
			}
		}
		for(int i = 0; i < cnt; i++) {
			if(goodNumSet.contains(arr[i])) answer++;
		}
		System.out.println(answer);
	}
	
}
