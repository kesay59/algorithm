

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 15961 회전초밥
public class BJ15961 {
	private static class Node {
		int kd;
		Node next;

		Node(int kd) {
			this.kd = kd;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int len = Integer.parseInt(st.nextToken());
		int kds = Integer.parseInt(st.nextToken());
		int cont = Integer.parseInt(st.nextToken());
		int cp = Integer.parseInt(st.nextToken());
		int[] ate = new int[kds + 1];

		Node head = new Node(-1);
		Node cur = head;
		for (int i = 0; i < len; i++) {
			cur.next = new Node(Integer.parseInt(br.readLine()));
			cur = cur.next;
		}
		cur.next = head.next;

		int tmp = 0;
		ate[cp]++;
		cur = head.next;
		for(int i = 0; i < cont; i++) {
			if (++ate[cur.kd] > 1) tmp++;
			cur = cur.next;
		}
		
		Node pre = head.next;
		for (int i = 0; i < len; i++) {
			if(--ate[pre.kd] > 0) tmp--;
			if (++ate[cur.kd] > 1) tmp++;
			min = Math.min(min, tmp);
			if(min == 0) break;
//			System.out.println(pre.next.kd + " ~ " + cur.kd + " = " + tmp);
			pre = pre.next;
			cur = cur.next;
		}
		System.out.println(cont - min + 1);

	}

}
