package string;

public class P557 {
	public static void main(String[] args) {
		String s="Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}
	public static String reverseWords(String s) {
		String rs="";
		String temp="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=' ') {
				temp+=s.charAt(i);
			}else {
				for(int j=temp.length()-1;j>=0;j--)
					rs+=temp.charAt(j);
				rs+=" ";
				temp="";
			}
		}
		for(int j=temp.length()-1;j>=0;j--)
			rs+=temp.charAt(j);
		return rs;
    }
}
