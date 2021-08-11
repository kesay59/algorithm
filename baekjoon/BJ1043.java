import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1043 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] isKnow = new boolean[N + 1];
		ArrayList<Integer>[] people = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			people[i] = new ArrayList<Integer>();
		}
		ArrayList<Integer>[] party = new ArrayList[M];
		for(int i = 0; i < M; i++) {
			party[i] = new ArrayList<Integer>();
		}
		Queue<Integer> known = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int person;
		for(int i = 0; i < len; i++) {
			person = Integer.parseInt(st.nextToken());
			isKnow[person] = true;
			known.offer(person);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			for(int j = 0; j < len; j++) {
				person = Integer.parseInt(st.nextToken());
				party[i].add(person);
				people[person].add(i);
			}
		}
		
		
		while(!known.isEmpty()) {
			int cur = known.poll();
			for(int i = 0; i < people[cur].size(); i++) {
				for(int j = 0; j < party[people[cur].get(i)].size(); j++) {
					if(!isKnow[party[people[cur].get(i)].get(j)]) {
						isKnow[party[people[cur].get(i)].get(j)] = true;
						known.offer(party[people[cur].get(i)].get(j));
					}
				}
			}
		}
		
		
		int ans = 0;
		for(int i = 0; i < M; i++) {
			int j = 0;
			for(; j < party[i].size(); j++) {
				if(isKnow[party[i].get(j)]) break;
			}
			if(j == party[i].size()) ans++;
		}
		System.out.println(ans);
	}

}