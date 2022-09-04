import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ2170 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<int[]> ll = new LinkedList<>();
		StringTokenizer st;
		int[] ele, target, next;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			ele = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int idx = 0;
			for(; idx < ll.size(); idx++) {
				if(ll.get(idx)[0] > ele[0]) break;
			}
			
			if(idx == 0) {
				ll.addFirst(ele);
				target = ele;
				idx++;
			} else {				
				target = ll.get(idx-1);
				if(target[1] > ele[0]) {
					target[1] = Math.max(target[1], ele[1]);
				} else {
					ll.add(idx, ele);
					target = ele;
					idx++;
				}
			}
			
			while(idx < ll.size()) {
				next = ll.get(idx);
				if(target[1] < next[0]) break;
				target[1] = Math.max(target[1], next[1]);
				ll.remove(next);
			}
		}
		int sum = 0;
		for(int[] line : ll) {
			sum += line[1] - line[0];
		}
		System.out.println(sum);
	}
}
