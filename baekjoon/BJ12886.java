import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ12886 {
	private static HashMap<Integer, HashMap<Integer, HashSet<Integer>>> vis = new HashMap<>();
	private static boolean checkVisited(int[] sortedArr) {
		if(!vis.containsKey(sortedArr[0])) vis.put(sortedArr[0], new HashMap<Integer, HashSet<Integer>>());
		if(!vis.get(sortedArr[0]).containsKey(sortedArr[1])) vis.get(sortedArr[0]).put(sortedArr[1], new HashSet<Integer>());
		if(!vis.get(sortedArr[0]).get(sortedArr[1]).contains(sortedArr[2])) {
			vis.get(sortedArr[0]).get(sortedArr[1]).add(sortedArr[2]);
			return false;
		}
		return true;		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[] {
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
		};
		Arrays.sort(arr);
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(arr);
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0] == cur[1] && cur[1] == cur[2]) {
				System.out.println(1);
				System.exit(0);
			}
			if(!checkVisited(cur)) {				
				for(int i = 0; i < 2; i++) {
					for(int j = i + 1; j < 3; j++) {
						if(cur[i] != cur[j]) {						
							arr = new int[] {
									cur[i] + cur[i],
									cur[j] - cur[i],
									cur[i==0?(j==1?2:1):(j==0?2:0)]
							};
							Arrays.sort(arr);
							que.offer(arr);
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}
