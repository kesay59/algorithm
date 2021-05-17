package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//백준 1946 신입 사원
public class BJ1946 {

	private static class Person{
		int a, b;

		public Person(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= test_case; tc++) {
			int cnt = 0;
			int len = Integer.parseInt(br.readLine());
			ArrayList<Person> arr = new ArrayList<>();
			StringTokenizer st;
			for(int i = 0; i < len; i++) {
				st = new StringTokenizer(br.readLine());
				arr.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(arr, new Comparator<Person>() {
				@Override
				public int compare(Person per1, Person per2) {
					return per1.a - per2.a;
				}
			});
			int min = len + 1;
			out : for(int i = 0 ; i < len; i++) {
				if(min < arr.get(i).b) continue out;
				min = arr.get(i).b;
				cnt++;
			}
			
			System.out.println(cnt);
			
		}
			

	}

}