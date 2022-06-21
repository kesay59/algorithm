import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1766 {
	private static class Vertex{
		int prevCnt;
		LinkedList<Integer> nextVertex;
		public Vertex() {
			prevCnt = 0;
			nextVertex = new LinkedList<Integer>();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Vertex[] vertexs = new Vertex[N + 1];
		for(int n = 1; n <= N; n++) {
			vertexs[n] = new Vertex();
		}
		int prev, next;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			prev = Integer.parseInt(st.nextToken());
			next = Integer.parseInt(st.nextToken());
			vertexs[prev].nextVertex.add(next);
			vertexs[next].prevCnt++;
		}
		PriorityQueue<Integer> problems = new PriorityQueue<Integer>();
		for(int n = 1; n < vertexs.length; n++) {
			if(vertexs[n].prevCnt == 0) problems.offer(n);
		}
		StringBuilder stb = new StringBuilder();
		while(!problems.isEmpty()) {
			int cur = problems.poll();
			stb.append(cur).append(' ');
			for(int v : vertexs[cur].nextVertex) {
				vertexs[v].prevCnt--;
				if(vertexs[v].prevCnt == 0) problems.offer(v);
			}
		}
		System.out.println(stb);
	}
}
