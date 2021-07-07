import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1931 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mNum = Integer.parseInt(br.readLine());
		Meeting[] arr = new Meeting[mNum];
		StringTokenizer st;
		for(int i = 0; i < mNum; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	
		}
		Arrays.sort(arr);
		int cur = 0;
		int cnt = 0;
		for(int i = 0; i < mNum; i++) 
			if(cur <= arr[i].start) {
				cur = arr[i].end;
				cnt++;
			}
		System.out.println(cnt);
	}

}

class Meeting implements Comparable<Meeting>{
	int start, end;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meeting o) {
		int tmp = Integer.compare(this.end, o.end);
		return tmp != 0 ? tmp : Integer.compare(this.start, o.start);
	}
	
}