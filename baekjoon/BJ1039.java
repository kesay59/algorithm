import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ1039 {


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		if(N < 10 || (N < 100 && N % 10 == 0) ) {
			System.out.println(-1);
			System.exit(0);
		}
		int K = Integer.parseInt(st.nextToken());
		
		Set<Integer>[] numSet = new HashSet[2];
		numSet[0] = new HashSet<Integer>();
		numSet[1] = new HashSet<Integer>();
		numSet[0].add(N);
		int flag = 0;
		char[] arr;
		char tmp;
		for(int k = 0; k < K; k++) {
			for(int num : numSet[flag]) {
				arr = Integer.toString(num).toCharArray();
				for(int j = 1; j < arr.length; j++) {
					if(arr[j] == 0) continue;
					tmp = arr[0];
					arr[0] = arr[j];
					arr[j] = tmp;
					numSet[flag^1].add(Integer.parseInt(new String(arr)));
					tmp = arr[0];
					arr[0] = arr[j];
					arr[j] = tmp;
				}
				for(int i = 1; i < arr.length - 1; i++) {
					for(int j = i + 1; j < arr.length; j++) {
						if(arr[j] == 0) continue;
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						numSet[flag^1].add(Integer.parseInt(new String(arr)));
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
			numSet[flag] = new HashSet<Integer>();
			flag ^= 1;
		}
		int maxValue = 0;
		for(int value : numSet[flag]) {
			maxValue = Math.max(maxValue, value);
		}
		System.out.println(maxValue);
	}

}
