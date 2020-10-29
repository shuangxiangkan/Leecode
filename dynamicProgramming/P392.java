package dynamicProgramming;

public class P392 {
	public static void main(String[] args) {
		String s="axc";
		String t="ahbgdc";
		System.out.println(isSubsequence(s, t));
	}
	public static boolean isSubsequence(String s, String t) {
		int i=0,j=0;
		for(;i<t.length()&&j<s.length();i++) {
			if(s.charAt(j)==t.charAt(i)) {
				j++;
			}
		}
		if(j==s.length())
			return true;
		else
			return false;
    }
}
