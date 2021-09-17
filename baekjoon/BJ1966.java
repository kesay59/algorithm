import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcN = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 0; tc < tcN; tc++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int qIdx = Integer.parseInt(st.nextToken());
			
			int[] imptList = new int[num];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < num; i++) {
				imptList[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] imptCntList = new int[10];
			for(int impt : imptList) {
				imptCntList[impt]++;
			}
			
			int stnd = imptList[qIdx];
			int sum = 0;
			for(int i = 9; i > stnd; i--) {
				sum += imptCntList[i];
			}
			
			int cur = 0;
			if(sum > 0) {
				cur = num - 1;
				for(int impt = 9; impt > stnd; impt--) {
					if(imptCntList[impt] == 0) continue;
					while(imptList[cur] != impt) {
						if(--cur < 0) cur += num;
					}
				}
			}
			
			while(cur != qIdx) {
				if(imptList[cur] == stnd) sum++;
				if(++cur == num) cur -= num;
			}
			System.out.println(sum + 1);
		}
	}
}
