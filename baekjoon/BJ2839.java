import java.util.Scanner;

//BJ 2839 설탕 배달
public class BJ2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int weight = sc.nextInt();
		int cnt = weight / 5;
		weight-=cnt*5;
		for(int i = 0; i <= cnt; i++) {
			if(weight % 3 == 0) {
				System.out.println(cnt - i + weight/3);
				System.exit(0);
			}
			weight += 5;
		}
		System.out.println(-1);
	}

}