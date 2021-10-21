import java.io.IOException;

public class BJ1439 {
	public static void main(String[] args) throws IOException {
		int cur, pre = 0, cnt0 = 0, cnt1 = 0;
		while((cur=(System.in.read())) > 47) {
			if(cur!=pre) {
				pre = cur;
				if(cur == 48) cnt0++;
				else cnt1++;				
			}
		}
		System.out.println(cnt0>cnt1?cnt1:cnt0);
	}
}