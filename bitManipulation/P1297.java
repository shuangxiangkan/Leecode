package bitManipulation;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P1297 {
	public static void main(String[] args) {
		String s = "aaaa";
		int maxLetters = 1;
		int minSize = 3;
		int maxSize = 3;
		P1297 p=new P1297();
		System.out.println(p.maxFreq(s, maxLetters, minSize, maxSize));
	}
	public boolean judge(String s,int maxLetters) {
		ArrayList<Character> alist=new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			if(!alist.contains(s.charAt(i))) {
				alist.add(s.charAt(i));
			}
		}
		if(alist.size()>maxLetters)
			return false;
		return true;
	}
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		Map<String , Integer> map=new HashMap<String, Integer>();
		for(int i=0;i<=s.length()-minSize;i++) {
			String sub=s.substring(i, i+minSize);
			if(judge(sub,maxLetters)) {
				
				if(map.containsKey(sub))
					map.put(sub, map.get(sub)+1);
				else
					map.put(sub, 1);
			}
		}
		int max=0;
		for(String str:map.keySet()) {
			if(map.get(str)>max)
				max=map.get(str);
		}
		return max;
    }
}
