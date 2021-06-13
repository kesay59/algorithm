import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] box = new char[row][];
		for(int i = 0; i < row; i++) {
			box[i] = br.readLine().toCharArray();
		}
		
		int size = row > col ? col - 1 : row - 1 ;
		out : for(; size >= 0; size--) {
			for(int i = 0; i + size < row; i++) {
				for(int j = 0; j + size < col; j++) {
					if(box[i][j]==box[i][j] && box[i][j]==box[i+size][j] && box[i][j]==box[i][j+size] && box[i][j]==box[i+size][j+size]) {
						System.out.println((size + 1) * (size + 1));
						break out;
					}
				}
			}
		}
	}
}
