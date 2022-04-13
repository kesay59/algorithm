import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1063 {
	private static boolean move(char[] pos, String type) {
		if("R".equals(type)) {
			if(pos[0] != 'H') pos[0]++;
			else return false;
		} else if("L".equals(type)) {
			if(pos[0] != 'A') pos[0]--;
			else return false;
		} else if("B".equals(type)) {
			if(pos[1] != '1') pos[1]--;
			else return false;
		} else if("T".equals(type)) {
			if(pos[1] != '8') pos[1]++;
			else return false;
		} else if("RT".equals(type)) {
			if(pos[0] != 'H' && pos[1] != '8') {
				pos[0]++;
				pos[1]++;
			}
			else return false;
		} else if("LT".equals(type)) {
			if(pos[0] != 'A' && pos[1] != '8') {
				pos[0]--;
				pos[1]++;
			}
			else return false;
		} else if("RB".equals(type)) {
			if(pos[0] != 'H' && pos[1] != '1') {
				pos[0]++;
				pos[1]--;
			}
			else return false;
		} else if("LB".equals(type)) {
			if(pos[0] != 'A' && pos[1] != '1') {
				pos[0]--;
				pos[1]--;
			}
			else return false;
		} 
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] king = st.nextToken().toCharArray();
		char[] stone = st.nextToken().toCharArray();
		int cnt = Integer.parseInt(st.nextToken());
		Map<String, String> reverse = Map.of(
				"R", "L", 
				"L", "R", 
				"B", "T", 
				"T", "B", 
				"RT", "LB", 
				"LB", "RT", 
				"LT", "RB", 
				"RB", "LT");
		for(int c = 0; c < cnt; c++) {
			String cmd = br.readLine();
			move(king, cmd);
			if(king[0] == stone[0] && king[1] == stone[1]) {
				if(!move(stone, cmd)) move(king, reverse.get(cmd));
			}
		}
		System.out.println(new String(king));
		System.out.println(new String(stone));
	}
}
