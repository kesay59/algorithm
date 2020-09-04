import java.util.Scanner;

//SW Expert Academy 4796 의석이의 우뚝 선 산
public class EA4796 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcN = sc.nextInt() + 1;
		for(int tc = 1; tc < tcN; tc++) {
			int len = sc.nextInt();
			int pre = 0;
			int cur = sc.nextInt();
			int cntL = 0;
			int cntR = 0;
			int sum = 0;
			boolean flag = true;
			int i = 0;
			while(true) {
				if(flag) {
					if(pre < cur) cntL++;
					else {
						flag ^= true;
						cntL--;
						continue;
					}
				} else {
					if(pre > cur) cntR++;
					else {
						sum += cntL*cntR;
						cntL = 1;
						cntR = 0;
						flag ^= true;
						continue;
					}
				}
				if(++i == len) break;
				pre = cur;
				cur = sc.nextInt();
			}
			if(!flag) sum += cntL * cntR;
			System.out.println("#" + tc + " " + sum);			
		}

	}

}
