import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 10942 팰린드롬?
public class BJ10942 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] adr = new ArrayList[100001];
		int[] arr = new int[len + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(adr[arr[i]] == null) {
				adr[arr[i]] = new ArrayList<Integer>();
				adr[arr[i]].add(i);
			} else {
				adr[arr[i]].add(i);
			}
		}
		
		
		int[][] mid = new int[2][len + 1];
		for(int i = 1; i <= 100000; i++) {
			if(adr[i] == null) continue;
			for(int a = 0; a < adr[i].size(); a++) {
				next : for(int b = a+1; b < adr[i].size(); b++) {
					int sn = adr[i].get(a);
					int en = adr[i].get(b);
					int bwl = en - sn + 1;
					if(mid[bwl % 2][en - bwl / 2] >= bwl) continue;
					for(int c = 0; c <= bwl / 2; c++) 
						if(arr[sn++] != arr[en--]) continue next;
					mid[bwl % 2][sn-1] = bwl;
				}
			}
		}
		
		int odn = Integer.parseInt(br.readLine());
		for(int od = 0; od < odn; od++) {
			st = new StringTokenizer(br.readLine());
			int sn = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int bwl = en - sn + 1;
			if(bwl == 1) {
				System.out.println(1);
				continue;
			}
			if(mid[bwl % 2][en - bwl / 2] < bwl) System.out.println(0);
			else System.out.println(1);
		}
	}

}
