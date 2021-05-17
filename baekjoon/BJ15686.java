import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//baekjoon 15686 치킨 배달
public class BJ15686 {

	private static class Leng implements Comparable<Leng>{
		int len, idx;
		Leng(int len, int idx){
			this.len = len;
			this.idx = idx;
		}
		@Override
		public int compareTo(Leng o) {
			return this.len - o.len;
		}
	}
	
	private static class House {
		int r, c;
		ArrayList<Leng> minList;
		
		House(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		
		void makeMinList(ArrayList<Chicken> chickens){
			minList = new ArrayList<>();
			for(int i = 0; i < chickens.size(); i++) {
				minList.add(new Leng(Math.abs(chickens.get(i).r - this.r) + Math.abs(chickens.get(i).c - this.c), i));
				Collections.sort(minList);
			}
		}
		
		int findMinList(int[] arr) {
			for(int i = 0; i < minList.size(); i++) {
				for(int a = 0; a < arr.length; a++) {
					if(arr[a] == minList.get(i).idx) {
						return minList.get(i).len;
					}
				}
			}
			return -1;
		}
		
	}
	
	private static class Chicken{
		int r, c;
		
		Chicken(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static void combination(int[] arr, int num, int idx) {
		if(num == sel || idx == chickens.size()) {
			int sum = 0;
			for(int i = 0; i < houses.size(); i++) 
				sum += houses.get(i).findMinList(arr);
			if(sum > 0 && sum < min) min = sum;
			return;
		}
		arr[num] = idx;
		combination(arr, num + 1, idx + 1);
		arr[num] = -1;
		combination(arr, num, idx + 1);
		return;
	}
	
	private static int sel;
	private static int min = Integer.MAX_VALUE;
	private static ArrayList<House> houses;
	private static ArrayList<Chicken> chickens;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		sel = Integer.parseInt(st.nextToken());
		char arr[][]  = new char[len][];
		houses = new ArrayList<House>();
		chickens = new ArrayList<Chicken>();
		
		for(int i = 0; i < len; i++) 
			arr[i] = br.readLine().replace(" ", "").toCharArray();
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(arr[i][j] == 49) 
					houses.add(new House(i, j));
				else if(arr[i][j] == 50) 
					chickens.add(new Chicken(i, j));
			}
		}
		
		for(int i = 0; i < houses.size(); i++) 
			houses.get(i).makeMinList(chickens);
		
		int[] tArr = new int[sel];
		for(int i = 0; i < sel; i++)
			tArr[i] = -1;
		combination(tArr, 0, 0);
		System.out.println(min);
	}
}
