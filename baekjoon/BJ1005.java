import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1005 {
	private static class Building {
		int buildTime;
		int completeTime;
		int prevCnt;
		List<Integer> nextBuilding;
		
		public Building(int buildTime) {
			this.buildTime = buildTime;
			this.completeTime = buildTime;
			this.prevCnt = 0;
			this.nextBuilding = new ArrayList<Integer>();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int buildingCnt = Integer.parseInt(st.nextToken());
			int ruleCnt = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Building[] buildings = new Building[buildingCnt + 1];
			for(int b = 1; b <= buildingCnt; b++) {
				buildings[b] = new Building(Integer.parseInt(st.nextToken()));
			}
			
			int prev, next;
			for(int rule = 0; rule < ruleCnt; rule++) {
				st = new StringTokenizer(br.readLine());
				prev = Integer.parseInt(st.nextToken());
				next = Integer.parseInt(st.nextToken());
				buildings[prev].nextBuilding.add(next);
				buildings[next].prevCnt++;
			}

			Queue<Integer> canBuildQ = new LinkedList<>();
			for(int b = 1; b < buildings.length; b++) {
				if(buildings[b].prevCnt == 0) {
					buildings[b].completeTime = buildings[b].buildTime;
					canBuildQ.offer(b);
				}
			}
			
			int res = Integer.parseInt(br.readLine());
			int cur;
			while(!canBuildQ.isEmpty()) {
				cur = canBuildQ.poll();
				if(cur == res) break;
				buildings[cur] = buildings[cur];
				for(int b : buildings[cur].nextBuilding) {
					buildings[b].prevCnt--;
					if(buildings[cur].completeTime + buildings[b].buildTime > buildings[b].completeTime) buildings[b].completeTime = buildings[cur].completeTime + buildings[b].buildTime;
					if(buildings[b].prevCnt == 0) canBuildQ.offer(b);
				}
			}
			System.out.println(buildings[res].completeTime);
		}
		
	}
}
