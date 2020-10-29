package string;

import java.util.HashMap;
import java.util.Map;

public class P1451 {
	public static void main(String[] args) {
		String text="Leetcode is cool";
//		String text="Keep calm and code on";
//		String text = "To be or not to be";
		System.out.println(arrangeWords(text));
	}
	public static String arrangeWords(String text) {
		StringBuilder sb=new StringBuilder();
		String[] s=text.trim().split(" ");
		Map<Integer, StringBuilder> map=new HashMap<Integer, StringBuilder>();
		
		for (String string : s) {
			int len=string.length();
			if(map.containsKey(len)) {
				map.put(len, map.get(len).append(" "+string));
			}else {
				map.put(len, new StringBuilder(string));
			}
		}
		for (Integer key : map.keySet()) {
			sb.append(map.get(key)+" ");
		}
		String temp=sb.toString();
		temp=temp.substring(0,1).toUpperCase().concat(temp.substring(1).toLowerCase());
		
		return temp;
    }
}
