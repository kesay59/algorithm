import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17615 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		char[] line = br.readLine().toCharArray();
		int rCnt = 0, bCnt = 0;
		for(char ch : line) {
			if(ch == 'R') rCnt++;
		}
		bCnt = line.length - rCnt;
		if(rCnt == 0 || bCnt == 0) {
			System.out.println(0);
			return;
		} 
		
		int minCnt = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i = 0; i < line.length; i++) {
			if(line[i] == 'R') cnt++;
			else break;
		}
		minCnt = Math.min(minCnt, rCnt - cnt);

		cnt = 0;
		for(int i = line.length-1; i >= 0; i--) {
			if(line[i] == 'R') cnt++;
			else break;
		}
		minCnt = Math.min(minCnt, rCnt - cnt);
		
		cnt = 0;
		for(int i = 0; i < line.length; i++) {
			if(line[i] == 'B') cnt++;
			else break;
		}
		minCnt = Math.min(minCnt, bCnt - cnt);
		
		cnt = 0;
		for(int i = line.length-1; i >= 0; i--) {
			if(line[i] == 'B') cnt++;
			else break;
		}
		minCnt = Math.min(minCnt, bCnt - cnt);
		
		System.out.println(minCnt);
	}
}
