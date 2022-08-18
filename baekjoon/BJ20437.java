import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ20437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			String line = br.readLine();
			int cnt = Integer.parseInt(br.readLine());
			
			List<Integer>[] list = new ArrayList[26];
			for(int i = 0; i < 26; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for(int idx = 0; idx < line.length(); idx++) {
				list[line.charAt(idx) - 'a'].add(idx);
			}
			
			int min = Integer.MAX_VALUE, max = -1;
			for(int i = 0; i < 26; i++) {
				if(list[i].size() >= cnt) {
					int f = 0, b = f + cnt - 1;
					for(; b < list[i].size(); f++, b++) {
						int num = list[i].get(b) - list[i].get(f) + 1;
						min = Math.min(min, num);
						max = Math.max(max, num);
					}
				}
			}
			if(max == -1) {
				System.out.println(-1);
			} else {
				System.out.println(min + " " + max);
			}
		}
	}
}
