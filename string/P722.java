package string;

import java.util.ArrayList;
import java.util.List;

public class P722 {
	public static void main(String[] args) {
//		String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
//		String[] source = {"a/*comment", "line", "more_comment*/b"};
		String[] source = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
		List<String> results=removeComments(source);
		for (String s : results) {
			System.out.println(s);
		}
	}
	public static List<String> removeComments(String[] source) {
		List<String> results=new ArrayList<String>();
		boolean flag=false;
		StringBuilder sb=new StringBuilder();
		for (String s : source) {
			int i=0;
			while(i<s.length()) {
				if(!flag&&i+1<s.length()&&s.charAt(i)=='/'&&s.charAt(i+1)=='*') {
					flag=true;
					i++;
				}else if(flag&&i+1<s.length()&&s.charAt(i)=='*'&&s.charAt(i+1)=='/') {
					flag=false;
					i++;
				}else if(!flag&&i+1<s.length()&&s.charAt(i)=='/'&&s.charAt(i+1)=='/') {
					break;
				}else if(!flag)
					sb.append(s.charAt(i));	
				i++;
			}
			if(!flag&&sb.length()>0) {
				results.add(sb.toString());
				sb=new StringBuilder();
			}
				
		}
		return results;
    }
}
