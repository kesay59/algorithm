import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10814 {
	private static class Person implements Comparable<Person>{
		int idx;
		int age;
		String name;
		Person(int idx, int age, String name){
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(Person o) {
			if(this.age == o.age) return this.idx - o.idx;
			return this.age-o.age;
		}
		@Override
		public String toString() {
			return age + " " + name;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Person[] personArray = new Person[num];
		StringTokenizer st;
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			personArray[i] = new Person(i, Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(personArray);
		for(Person person : personArray) {
			System.out.println(person);
		}
	}
	
}
