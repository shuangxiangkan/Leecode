package twoPointers;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> alist=new ArrayList<>();
		alist.add(0);
		alist.add(1);
		alist.add(2);
		alist.add(2);
		for (Integer a : alist) {
			System.out.println(a);
		}
		System.out.println("--------------");
		alist.remove(2);
		for (Integer a : alist) {
			System.out.println(a);
		}
	}
	
}
