import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ23797 {
	public static void main(String[] args) throws IOException {
		String S = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int kFlogCnt = 0, pFlogCnt = 0, kMaxCnt = 0, pMaxCnt = 0;
		char stdCh = ' ';
		for(int idx = 0; idx < S.length(); idx++) {
			if(S.charAt(idx) == 'K') {
				if(pFlogCnt == 0) {
					kFlogCnt++;
				} else {
					pFlogCnt--;
				}
			} else {
				if(kFlogCnt == 0) {
					pFlogCnt++;
				} else {
					kFlogCnt--;
				}
			}
			kMaxCnt = Math.max(kMaxCnt, kFlogCnt);
			pMaxCnt = Math.max(pMaxCnt, pFlogCnt);
		}
		System.out.println(kMaxCnt + pMaxCnt);
	}
}
