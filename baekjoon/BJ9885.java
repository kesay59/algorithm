import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ9885 {
	private static class Hinge implements Comparable<Hinge>{
		int parent;
		List<Integer> children;
		int bar;
		int level;
		int grade;
		
		public Hinge(int parent, int bar) {
			this.parent = parent;
			this.children = new ArrayList<>();
			this.bar = bar;
			this.grade = 0;
		}
		
		@Override
		public int compareTo(Hinge o) {
			return o.level - this.level;
		}
		
	}
	
	private static Hinge[] hinges;
	private static long maxWeight = 0;
	private static void findLevel(Hinge hinge) {
		if(hinge.level != 0) return;
		findLevel(hinges[hinge.parent]);
		hinge.level = hinges[hinge.parent].level + 1;
	}
	private static int findGrade(Hinge hinge, int barSumFromRoot) {
		int sum = 0;
		if(!hinge.children.isEmpty()) {
			for(int idx : hinge.children) {
				sum += findGrade(hinges[idx], barSumFromRoot + hinge.bar);
			}
		}
		hinge.grade = sum + barSumFromRoot + hinge.bar;
		return sum + hinge.bar;
	}
	private static void findWeight(Hinge hinge, long gradeSumFromRoot) {
		if(hinge.children.isEmpty()) {
			maxWeight = Math.max(maxWeight, gradeSumFromRoot + hinge.grade);
			return;
		}
		for(int idx : hinge.children) {
			findWeight(hinges[idx], gradeSumFromRoot + hinge.grade);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hinges = new Hinge[N+1];
		StringTokenizer st;
		for(int n = 1; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			hinges[Integer.parseInt(st.nextToken())] = new Hinge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int rootIdx = -1;
		for(int n = 1; n <= N; n++) {
			if(hinges[n] == null) {
				rootIdx = n;
				hinges[n] = new Hinge(n, 0);
				hinges[n].level = 1;
				break;
			}
		}
		for(int n = 1; n <= N; n++) {
			if(n == rootIdx) continue;
			hinges[hinges[n].parent].children.add(n);
		}
		for(int n = 1; n <= N; n++) {
			findLevel(hinges[n]);
		}
		
		findGrade(hinges[rootIdx], 0);
		findWeight(hinges[rootIdx], 0);
		System.out.println(maxWeight);
	}
}
