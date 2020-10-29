//package sort;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Person implements Comparable<Person>{
//	int age;
//	String name;
//	
//	
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Person(String name,int age) {
//		super();
//		this.age = age;
//		this.name = name;
//	}
//	@Override
//	public int compareTo(Person person) {
//		// TODO Auto-generated method stub
//		return name.compareTo(person.name);
//	}
//	public static void main(String[] args) {
//		ArrayList<Person> list=new ArrayList<>();
//		list.add(new Person("ccc",20));
//		list.add(new Person("aaa",30));
//		list.add(new Person("bbb",10));
//		list.add(new Person("ddd",40));
////		System.out.printf("Original sort, list:%s\n", list);
////		Collections.sort(list);
////		System.out.printf("Name sort, list:%s\n", list);
//	}
//
//}
//class AscAgeComparator implements Comparator<Person>{
//
//	@Override
//	public int compare(Person p1, Person p2) {
//		// TODO Auto-generated method stub
//		return p1.getAge()-p2.getAge();
//	}
//	
//}
//
//class DecAgeComparator implements Comparator<Person>{
//
//	@Override
//	public int compare(Person p1, Person p2) {
//		// TODO Auto-generated method stub
//		return p2.getAge()-p1.getAge();
//	}
//
//	
//	
//}
