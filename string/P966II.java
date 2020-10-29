package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P966II {
	List<String> list;
	Map<String, String> mapLowerCase;
	Map<String, String> mapVowel;
	public static void main(String[] args) {
		String[] wordlist = {"KiTe","kite","hare","Hare"};
		String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
		P966II t=new P966II();
		String[] resutls=t.spellchecker(wordlist, queries);
		for (String string : resutls) {
			System.out.println(string);
		}
	}
	public String[] spellchecker(String[] wordlist, String[] queries) {
		list=new ArrayList<String>();
		mapLowerCase=new HashMap<String, String>();
		mapVowel=new HashMap<String, String>();
		for(String word:wordlist) {
			list.add(word);
			
			String t=word.toLowerCase();
			mapLowerCase.putIfAbsent(t, word);
			
			mapVowel.putIfAbsent(VowelString(t), word);
		}
		
		String[] results=new String[queries.length];
		int i=0;
		for(String s:queries) {
			results[i++]=solve(s);
		}
		
		return results;
		
	}
	public String solve(String s) {
		if(list.contains(s))
			return s;
		
		String t=s.toLowerCase();
		if(mapLowerCase.containsKey(t))
			return mapLowerCase.get(t);
		
		String p=VowelString(t);
		if(mapVowel.containsKey(p))
			return mapVowel.get(p);
		
		return "";
	}
	public String VowelString(String word) {
		StringBuilder sb=new StringBuilder();
		for(char c:word.toCharArray())
			sb.append(isVowel(c)?'*':c);
		return sb.toString();
	}
	public boolean isVowel(char c) {
		return (c=='a'||c=='o'||c=='e'||c=='i'||c=='u');
	}
}
