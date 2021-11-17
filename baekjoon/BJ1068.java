import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1068 {
	private static List<Integer>[] tree;
	
	private static int findLeaf(int nodeNum) {
		if(tree[nodeNum].size() == 0) return 1;
		int sum = 0;
		for(int nextNodenum : tree[nodeNum]) {
			sum += findLeaf(nextNodenum);
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		tree = new ArrayList[num];
		int root = -1;
		for(int i = 0; i < num; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int delNode = Integer.parseInt(br.readLine());
		int cur = -1;
		for(int i = 0; i < num; i++) {
			cur = Integer.parseInt(st.nextToken());
			if(delNode == i) continue;
			if(cur == -1) root = i;
			else tree[cur].add(i);
		}
		if(root == -1) {
			System.out.println(0);
			System.exit(0);
		}
		System.out.println(findLeaf(root));
	}
}
