import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1374 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] staLecture = new int[num];
		int[] endLecture = new int[num];
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			staLecture[i] = Integer.parseInt(st.nextToken());
			endLecture[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(staLecture);
		Arrays.sort(endLecture);
		
		int staIdx = 0, endIdx = 0, time = 1, room = 0, maxRoom = 0;
		while(staIdx < num) {
			while(endLecture[endIdx] < time) {
				room--;
				endIdx++;
			}
			while(staIdx < num && staLecture[staIdx] < time) {
				room++;
				staIdx++;
			}
			maxRoom = Math.max(maxRoom, room);
			time++;
		}
		System.out.println(maxRoom);
		
//		List<int[]> lectures = new ArrayList<>();
//		for(int i = 0; i < num; i++) {
//			st = new StringTokenizer(br.readLine());
//			lectures.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
//		}
//		Collections.sort(lectures, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if(o1[2] == o2[2]) return o1[1] - o2[1];
//				return o1[2] - o2[2];
//			}	
//		});
		
		
	}
}
