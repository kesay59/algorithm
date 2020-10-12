import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BJ 1781 컵라면
public class BJ1781 {

	private static class Problem implements Comparable<Problem>{
		int cup, dead;

		public Problem(int dead, int cup) {
			this.cup = cup;
			this.dead = dead;
		}
		
		@Override
		public int compareTo(Problem o) {
			if(o.cup == this.cup) return this.dead - o.dead;
			return o.cup - this.cup;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		
		Problem[] arr = new Problem[len];
		StringTokenizer st;
		for(int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		//컵라면 높음 -> 데드라인 낮음 순으로 소팅
		Arrays.sort(arr);
		
		//N크기 배열 만들고 앞에서부터 먹는데 데드라인이 이미 true면 그 앞번호로 이동, 0까지 오면 선택불가
		int sum = 0;
		boolean[] sel = new boolean[len];
		for(int i = 0; i < len; i++) {
			int tmp = arr[i].dead - 1;
			while(tmp >= 0) {
				if(!sel[tmp--]) {
					sum += arr[i].cup;
					sel[tmp + 1] = true;
					break;
				}
			}
		}
		
		//배열 끝까지 돌면 합 출력
		System.out.println(sum);
	}

}
