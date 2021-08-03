import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BJ10610 {

	public static void main(String[] args) throws IOException {
		boolean flag = false;
		StringBuilder stb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();
		int sum = 0;
		for(int ch = System.in.read() - 48; ch >= 0; ch = System.in.read() - 48) {
			if(ch == 0) flag = true;
			sum += ch;
			arr.add(ch);
		}
		if(flag && sum % 3 == 0) {
			Collections.sort(arr);
			for(int i = arr.size() - 1; i >= 0; i--)
				stb.append(arr.get(i));
		}
		else stb.append(-1);
		
		if(stb.charAt(0) == '0') System.out.println(0);
		else System.out.println(stb);
	}

}