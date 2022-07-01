import java.io.IOException;

public class BJ15904 {
	public static void main(String[] args) throws IOException {
		int[] arr = new int[] {'U', 'C', 'P', 'C'};
		int bt = 32, idx = 0;
		while(bt >= 32) {
			bt = System.in.read();
			if(bt == arr[idx]) {
				idx++;
				if(idx == 4) break;
			}
		}
		System.out.println(idx == 4 ? "I love UCPC" : "I hate UCPC");
	}
}
