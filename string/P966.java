package string;

import java.util.ArrayList;
import java.util.List;

public class P966 {
	public static void main(String[] args) {
		String[] wordlist = {"KiTe","kite","hare","Hare"};
		String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
		String[] resutls=spellchecker(wordlist, queries);
		for (String string : resutls) {
			System.out.println(string);
		}
	}
	public static String[] spellchecker(String[] wordlist, String[] queries) {
		String[] results=new String[queries.length];
		List<String> list=new ArrayList<String>();
		for (String w : wordlist) {
			list.add(w.toLowerCase());
		}
		for (int i=0;i<queries.length;i++) {
			if(list.contains(queries[i].toLowerCase())) {
				String temp="";
				for(int j=0;j<wordlist.length;j++) {
					if(wordlist[j].equals(queries[i])) {
						results[i]=queries[i];
						break;
					}
					else if((temp.equals(""))&&(wordlist[j].toLowerCase().equals(queries[i].toLowerCase())))
						temp=wordlist[j];
				}
				if(results[i]==null)
					results[i]=temp;
					
			}else {
//				String s="aoeiu";
				List<Character> s=new ArrayList<>();
				s.add('a');
				s.add('o');
				s.add('e');
				s.add('i');
				s.add('u');
				
				String temp="";
				for(int k=0;k<wordlist.length;k++) {
					boolean flag=true;
					temp="";
					if(wordlist[k].length()==queries[i].length()) {
						for(int m=0;m<wordlist[k].length();m++) {
							if(list.get(k).charAt(m)!=queries[i].toLowerCase().charAt(m)) {
								if(!s.contains(list.get(k).charAt(m))||!s.contains(queries[i].toLowerCase().charAt(m))){
									flag=false;
									break;
								}
							}
							
						}
						if(flag) {
							temp=wordlist[k];
							break;
						}
//						break;
					}
//					else {
//						flag=false;
//					}
				}
				results[i]=temp;
			}
		}
		return results;
    }
}
