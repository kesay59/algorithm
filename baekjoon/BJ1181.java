import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//단어 정렬
public class BJ1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		HashSet<String> hs = new HashSet<String>();
		for(int n = 0 ;n < num; n++) 
			hs.add(br.readLine());
		ArrayList<String>[] al = new ArrayList[51];
		for(int l = 1; l < 51; l++) 
			al[l] = new ArrayList<String>();
		
		for(String w : hs) 
			al[w.length()].add(w);
		for(int l = 1; l < 51; l++) 
			Collections.sort(al[l]);
		
		for(int l = 1; l < 51; l++) {
			for(String w : al[l])
				System.out.println(w);
		}
	}
}
