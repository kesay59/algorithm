import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BJ 1049 기타줄
public class BJ1049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int bNum = Integer.parseInt(st.nextToken());
		int sixMin = 1000;
		int oneMin = 1000;
		int tmpS, tmpO;
		for(int b = 0; b < bNum; b++) {
			st = new StringTokenizer(br.readLine());
			tmpS = Integer.parseInt(st.nextToken());
			if(tmpS < sixMin) sixMin = tmpS;
			tmpO = Integer.parseInt(st.nextToken());
			if(tmpO < oneMin) oneMin = tmpO;
		}
		int min = sixMin * (num / 6) + oneMin * (num % 6);
		tmpS = sixMin * (num / 6 + 1);
		if(tmpS < min) min = tmpS;
		tmpO = oneMin * num;
		if(tmpO < min) min = tmpO;
		System.out.println(min);
	}

}