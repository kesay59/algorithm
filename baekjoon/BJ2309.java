import java.util.Arrays;
import java.util.Scanner;

//백준 2309 일곱난쟁이
public class Main {
	private static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		int sum = 0;
		for(int i = 0 ; i< 9; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		int stnd = sum - 100;
		Arrays.sort(arr);
		int i= 0, j = 0;
		out : for(; i < 9; i++) {
			for(j = i; j < 9; j++) {
				if(arr[i]+arr[j] == stnd) {
					break out;
				}
			}
		}
		for(int k = 0; k < 9; k++) {
			if(k == i || k == j) continue;
			System.out.println(arr[k]);
		}
	}

}
