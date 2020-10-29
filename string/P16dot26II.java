package string;

import java.util.Stack;

public class P16dot26II {
	public static void main(String[] args) {
//		String s="3+2*2";
//		String s="3+1+4";
		String s=" 3/2 ";
//		String s=" 3+5 / 2 ";
//		String s="2-3+4";
//		String s="14-3/2";
//		String s="1*2-3/4+5*6-7*8+9/10";
		System.out.println(calculate(s));
	}
	public static int calculate(String s) {
		s=s.trim();
		Stack<Integer> nums=new Stack<>();
		StringBuffer sb=new StringBuffer();
		char a='+';
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=' ') {
				if(Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
				}
				if((!Character.isDigit(s.charAt(i)))||i==s.length()-1){
					int num=Integer.parseInt(sb.toString());
					sb.delete(0, sb.length());
					
					switch (a) {
					case '+':
						nums.push(num);
						break;

					case '-':
						nums.push(-num);
						break;
					
					case '*':
						int b=nums.pop();
						nums.push(b*num);
						break;
					
					case '/':
						int c=nums.pop();
						nums.push(c/num);
						break;
					}
					a=s.charAt(i);
				
				}
			}
		}
		int result=0;
		while(!nums.isEmpty())
			result+=nums.pop();
		return result;
	}
}
