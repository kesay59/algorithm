import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ20436 {
	public static void main(String[] args) throws IOException {
		Map<Character, int[]> keyboard = new HashMap<Character, int[]>();
		keyboard.put('q', new int[] {0, 0, 0});
		keyboard.put('w', new int[] {0, 0, 1});
		keyboard.put('e', new int[] {0, 0, 2});
		keyboard.put('r', new int[] {0, 0, 3});
		keyboard.put('t', new int[] {0, 0, 4});
		keyboard.put('y', new int[] {1, 0, 5});
		keyboard.put('u', new int[] {1, 0, 6});
		keyboard.put('i', new int[] {1, 0, 7});
		keyboard.put('o', new int[] {1, 0, 8});
		keyboard.put('p', new int[] {1, 0, 9});
		keyboard.put('a', new int[] {0, 1, 0});
		keyboard.put('s', new int[] {0, 1, 1});
		keyboard.put('d', new int[] {0, 1, 2});
		keyboard.put('f', new int[] {0, 1, 3});
		keyboard.put('g', new int[] {0, 1, 4});
		keyboard.put('h', new int[] {1, 1, 5});
		keyboard.put('j', new int[] {1, 1, 6});
		keyboard.put('k', new int[] {1, 1, 7});
		keyboard.put('l', new int[] {1, 1, 8});
		keyboard.put('z', new int[] {0, 2, 0});
		keyboard.put('x', new int[] {0, 2, 1});
		keyboard.put('c', new int[] {0, 2, 2});
		keyboard.put('v', new int[] {0, 2, 3});
		keyboard.put('b', new int[] {1, 2, 4});
		keyboard.put('n', new int[] {1, 2, 5});
		keyboard.put('m', new int[] {1, 2, 6});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] tmp = keyboard.get(st.nextToken().charAt(0));
		int[] leftHand = new int[] {tmp[1], tmp[2]};
		tmp = keyboard.get(st.nextToken().charAt(0));
		int[] rightHand = new int[] {tmp[1], tmp[2]};
		int timeSum = 0;
		for(char ch : br.readLine().toCharArray()) {
			tmp = keyboard.get(ch);
			if(tmp[0] == 0) {
				timeSum += Math.abs(leftHand[0] - tmp[1]) + Math.abs(leftHand[1] - tmp[2]);
				leftHand[0] = tmp[1];
				leftHand[1] = tmp[2];
			}
			else {
				timeSum += Math.abs(rightHand[0] - tmp[1]) + Math.abs(rightHand[1] - tmp[2]);
				rightHand[0] = tmp[1];
				rightHand[1] = tmp[2];
			}
			timeSum++;
		}
		System.out.println(timeSum);
	}
}
