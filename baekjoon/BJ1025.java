import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1025 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		if(row == 0 || col == 0) {
			System.out.println(-1);
			System.exit(0);
		}
		char[][] table = new char[row][];
		for(int r = 0; r < row; r++) {
			table[r] = br.readLine().toCharArray();
		}
		
		StringBuilder stb;
		int answer = -1;
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				for(int m = row * -1; m < row; m++) {
					for(int n = col * -1; n < col; n++) {
						if(m == 0 && n == 0) continue;
						stb = new StringBuilder();
						int i = r;
						int j = c;
						char endCh;
						int numSq, num;
						while(i >= 0 && i < row && j >= 0 && j < col) {
							stb.append(table[i][j]);
							i += m;
							j += n;
							endCh = stb.charAt(stb.length()-1);
							if(endCh == 2 || endCh == 3 || endCh == 7 || endCh == 8) continue;
							numSq = Integer.parseInt(stb.toString());
							num = (int)(Math.sqrt(numSq) + 0.5);
							if(num * num == numSq) {
								answer = Math.max(answer, numSq);
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}
