import java.util.Scanner;

//BJ 2292 벌집
public class BJ2292{
	public static int execute(int N) {
		long start = 1;
		long ad = 6;
		int cnt = 1;
		while(start < N) {
			start += ad;
			ad += 6;
			cnt++;
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(execute(sc.nextInt()));
	}

}