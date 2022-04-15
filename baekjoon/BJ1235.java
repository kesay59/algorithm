import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ1235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String[] students = new String[num];
		for(int n = 0; n < num; n++) {
			students[n] = br.readLine();
		}
		out : for(int i = students[0].length() - 1; i >= 0; i--) {
			HashSet<String> hs = new HashSet<String>();
			for(String student : students) {
				String subStr = student.substring(i);
				if(hs.contains(subStr)) continue out;
				hs.add(subStr);
			}
			System.out.println(students[0].length() - i);
			break;
		}
	}
}
