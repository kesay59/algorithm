import java.util.Scanner;

public class BJ2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] arr = new int[input];
		for(int i = 0; i < input; i++)
			arr[i] = i;
		int idx = input;
		while(idx != 1) {
			if(idx % 2 == 0) {
				idx /= 2;
				for(int i = 0; i < idx; i++) 
					arr[i] = arr[i*2 + 1];
			}
			else {
				arr[0] = arr[idx-1];
				idx = idx / 2 + 1;
				for(int i = 0; i < idx -1; i++) 
					arr[i+1] = arr[i*2 + 1];
			}
		}
		System.out.println(arr[0] + 1);
	}

}
