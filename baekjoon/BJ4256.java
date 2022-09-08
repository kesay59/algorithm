import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4256 {
	private static int rootIdx;
	private static int[] preOrder, inOrder;
	private static StringBuilder answer;
	private static void make(int sta, int end) {
		if(rootIdx >= preOrder.length || sta > end) return;
		if(sta == end) {
			answer.append(inOrder[sta]).append(' ');
			rootIdx++;
			return;
		}
		int std = sta;
		for(; std <= end; std++) {
			if(inOrder[std] == preOrder[rootIdx]) break;
		}
		rootIdx++;
		make(sta, std-1);
		make(std+1, end);
		answer.append(inOrder[std]).append(' ');
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			preOrder = new int[len];
			for(int i = 0; i < len; i++) {
				preOrder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			inOrder = new int[len];
			for(int i = 0; i < len; i++) {
				inOrder[i] = Integer.parseInt(st.nextToken());
			}
			answer = new StringBuilder();
			rootIdx = 0;
			make(0, len-1);
			System.out.println(answer);
		}
	}
}
// [3] | 6 5 4 8 | 7 1 2 
// 5 6 8 4 | [3] | 1 2 7
// 5 8 4 6 | 2 1 7 | [3]

// [6] | 5 | 4 8
// 5 | [6] | 8 4
// 5 | 8 4 | [6]

// | [5] | 

// [4] | | 8
// 8 | [4] | 
// 8 | | [4]