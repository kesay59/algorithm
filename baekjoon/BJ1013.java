import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ1013 {
	
	private static HashMap<String, Boolean> table  = new HashMap<>();
	
	private static boolean check(String pattern) {
		if(table.containsKey(pattern)) return table.get(pattern);
		
		if(pattern.length() < 4) return false;
		
		if("100".equals(pattern.substring(0, 3))) {
			int i = 3;
			for(; i < pattern.length() - 1; i++) {
				if(pattern.charAt(i) != '0') break;
			}
			for(; i < pattern.length(); i++) {
				if(pattern.charAt(i) != '1') break;
			}
			if(i == pattern.length()) {
				table.put(pattern, true);
				return true;				
			}
		}
		
		for(int i = 2; i <= pattern.length() - 2; i++) {
			if(check(pattern.substring(0, i)) && check(pattern.substring(i))) {
				table.put(pattern, true);
				return true;
			}
		}
		table.put(pattern, false);
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		table.put("01", true);
		
		for(int t = 0; t < tc; t++) {
			if(check(br.readLine())) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
