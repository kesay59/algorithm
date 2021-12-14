import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		List<Integer>[] connNodeList = new ArrayList[num+1];
		for(int k = 1; k <= num; k++) {
			connNodeList[k] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		int nodeA, nodeB;
		for(int k = 1; k < num; k++) {
			st = new StringTokenizer(br.readLine());
			nodeA = Integer.parseInt(st.nextToken());
			nodeB = Integer.parseInt(st.nextToken());
			connNodeList[nodeA].add(nodeB);
			connNodeList[nodeB].add(nodeA);
		}
		int[] level = new int[num+1];
		int[] parent = new int[num+1];
		Arrays.fill(level, -1);
		level[1] = 0;
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(1);
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int node : connNodeList[cur]) {
				if(level[node] == -1) {
					level[node] = level[cur] + 1;
					parent[node] = cur;
					que.offer(node);
				}
			}
		}
		StringBuilder stb = new StringBuilder();
		for(int i = 2; i <= num; i++) {
			stb.append(parent[i]).append('\n');
		}
		System.out.println(stb);
	}
}
