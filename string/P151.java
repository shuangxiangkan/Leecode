package string;

import java.util.ArrayList;
import java.util.List;

public class P151 {
	public static void main(String[] args) {
//		String s="a good   example";
		String s="  hello world!  ";
		System.out.println(reverseWords(s));
	}
	public static String reverseWords(String s) {
		s.trim();
		StringBuilder sb=new StringBuilder();
		int start=s.length()-1;
		int end=start;
		while(start>=0) {
			while(start>=0&&s.charAt(start)!=' ')start--;
			sb.append(s.substring(start+1, end+1)+" ");
			while(start>=0&&s.charAt(start)==' ')start--;
			end=start;
		}
		return sb.toString().trim();
    }
//	public static String reverseWords(String s) {
//		String temp="";
//		List<String> list=new ArrayList<String>();
//		for(int i=0;i<s.length();i++) {
//			if(s.charAt(i)==' ') {
//				if(temp!="") 
//					list.add(temp);
//				temp="";
//			}else
//				temp+=s.charAt(i);
//		}
//		if(temp!="")
//			list.add(temp);
//		String r="";
//		for(int i=list.size()-1;i>=0;i--)
//			r+=list.get(i)+" ";
//		return r.trim();
//    }
}
