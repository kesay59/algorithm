import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class BJ2458 {
	
	private static class Node {
		ArrayList<Integer> up, down;
		boolean[] check; 
		public Node(int num) {
			up = new ArrayList<>();
			down = new ArrayList<>();
			check = new boolean[num + 1];
		}
	}
	
	private static Node[] arr;
	
	private static void upcheck(Node cur, boolean[] check) {
		for(int i : cur.up) {
			if(check[i]) continue;
			check[i] = true;
			upcheck(arr[i], check);
		}
	}
	
	private static void downcheck(Node cur, boolean[] check) {
		for(int i : cur.down) {
			if(check[i]) continue;
			check[i] = true;
			downcheck(arr[i], check);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		arr = new Node[num + 1];
		for(int i = 1; i < num + 1; i++) {
			arr[i] = new Node(num);
			arr[i].check[i] = true;
		}
		for(int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			arr[min].up.add(max);
			arr[max].down.add(min);
		}
		int cnt = 0;
		out : for(int i = 1; i < num + 1; i++) {
			upcheck(arr[i], arr[i].check);
			downcheck(arr[i], arr[i].check);
			for(int n = 1; n < num + 1; n++)
				if(!arr[i].check[n]) continue out;
			cnt++;
		}
		System.out.println(cnt);
	}

}
