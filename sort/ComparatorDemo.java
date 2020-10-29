package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	public static void main(String[] args) {
		List<Person> people=new ArrayList<Person>();
		people.add(new Person("Joe", 24));
		people.add(new Person("Pete", 18));
		people.add(new Person("Chris", 21));
		Collections.sort(people,new LexicographicComparator());
		System.out.println(people);
		Collections.sort(people,new Comparator<Person>() {

			@Override
			public int compare(Person a, Person b) {
				// TODO Auto-generated method stub
				return a.name.compareToIgnoreCase(b.name);
			}
		});
		System.out.println(people);
	}
	
}
class LexicographicComparator implements Comparator<Person>{

	@Override
	public int compare(Person a, Person b) {
		// TODO Auto-generated method stub
		return a.name.compareToIgnoreCase(b.name);
	}
	
}
class Person{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("{name=%s, age=%d}", name,age);
	}
	
}
