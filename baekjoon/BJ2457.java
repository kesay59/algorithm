import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2457 {
	private static class Flower implements Comparable<Flower>{
		int start, end;
		
		Flower(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Flower o) {
			return this.start - o.start;
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Flower[] arr = new Flower[num];
		StringTokenizer st;
		int start, end;
		String sm, sd, em, ed;
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			sm = st.nextToken();
			sd = st.nextToken();
			start = Integer.parseInt(sd.length() == 1 ? sm + "0" + sd : sm + sd);
			em = st.nextToken();
			ed = st.nextToken();
			end = Integer.parseInt(ed.length() == 1 ? em + "0" + ed : em + ed);
			arr[i] = new Flower(start, end);
		}
		Arrays.sort(arr);
		if(arr[0].start > 301) {
			System.out.println(0);
			System.exit(0);
		}
		
		int stnd = 301, idx = 0, maxEnd = 0, cnt = 0;
		while(true) {
			while(idx < arr.length) {
				if(arr[idx].start > stnd) {
					break;
				}
				else {
					maxEnd = Math.max(maxEnd, arr[idx++].end);
				}
			}
			
			if(maxEnd == 0) {
				cnt = 0;
				break;
			}
			cnt++;
			if(maxEnd > 1130) break;
			stnd = maxEnd;
			maxEnd = 0;
		}
		System.out.println(cnt);
	}
}
