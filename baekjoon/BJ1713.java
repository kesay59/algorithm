import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1713 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int slotCnt = Integer.parseInt(br.readLine());
		int voteCnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> slot = new LinkedList<>();
		int[] vote = new int[101];
		for(int v = 0; v < voteCnt; v++) {
			int num = Integer.parseInt(st.nextToken());
			if(vote[num] == 0) {
				if(slot.size() == slotCnt) {
					int minIdx = 0;
					int idx = 0;
					for(int s : slot) {
						if(vote[s] < vote[slot.get(minIdx)]) minIdx = idx;
						idx++;
					}
					vote[slot.get(minIdx)] = 0;
					slot.remove(minIdx);
				}
				slot.offerLast(num);
			}
			vote[num]++;
		}
		Collections.sort(slot);
		StringBuilder stb = new StringBuilder();
		for(int s : slot) {
			stb.append(" ").append(s);
		}
		System.out.println(stb.toString().trim());
	}
}
