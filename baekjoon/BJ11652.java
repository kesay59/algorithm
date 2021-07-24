import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ11652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		Long key = 0L;
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		for(int i = 0; i < num; i++) {
			key = Long.parseLong(br.readLine());
			if(hm.containsKey(key)) hm.put(key, hm.get(key).intValue() + 1);
			else hm.put(key, 1);
		}
		
		Long maxKey = key;
		for(Long ikey : hm.keySet()) {
			if(hm.get(ikey).intValue() > hm.get(maxKey).intValue()) {
				maxKey = ikey;
			} 
			else if(hm.get(ikey).intValue() == hm.get(maxKey).intValue() && ikey < maxKey) {
				maxKey = ikey;
			}
		}
		System.out.println(maxKey);
	}
}
