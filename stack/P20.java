package stack;

import java.util.Stack;

public class P20 {
	public static void main(String[] args) {
		String s="()[]{}";
		P20 p=new P20();
		System.out.println(p.isValid(s));
	}
	public boolean isValid(String s) {
		if(s.length()%2==1)
			return false;
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='('||c=='['||c=='{')
				stack.add(c);
			else { 
				if(stack.isEmpty())
					return false;
				char p=stack.pop();
				if(c==')'&&p!='(')
					return false;
				else if(c==']'&&p!='[')
					return false;
				else if(c=='}'&&p!='{')
					return false;
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
    }
}
