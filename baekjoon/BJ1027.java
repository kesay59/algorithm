import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1027 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] building = new int[cnt];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < cnt; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] table = new int[cnt];
		
		for(int i = 0; i < cnt - 1; i++) {
			next : for(int j = i + 1; j < cnt; j++) {
				
				double m = ((double)building[j] - building[i]) / (j - i);
				double b = building[i] - m * i;
				
				for(int k = i + 1; k < j; k++) {
					if(building[k] >= m * k + b) continue next;
				}
				
				table[i]++;
				table[j]++;
			}
		}
		
		int answer = 0;
		for(int i = 1; i < cnt; i++) {
			if(table[answer] < table[i]) answer = i;
		}
		System.out.println(table[answer]);
	}
}

//점에서 특정 점까지 직선 긋기 (i, j) - 직선방정식
