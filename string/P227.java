package string;

import java.util.Stack;

public class P227 {
	public static void main(String[] args) {
//		String s="3+2*2";
//		String s=" 3/2 ";
//		String s=" 3+5 / 2 ";
		String s="1*2-3/4+5*6-7*8+9/10";
		P227 p=new P227();
		System.out.println(p.calculate(s));
	}
	public int calculate(String s) {
		Stack<Integer> nums=new Stack<>();
		Stack<Character> ops=new Stack<>();
		char[] arrays=s.toCharArray();
		int temp=-1;
		for(int i=0;i<arrays.length;i++){
			if(isDigit(arrays[i])) {
				if(temp==-1)
					temp=arrays[i]-'0';
				else {
					temp=temp*10+arrays[i]-'0';
				}
			}
			if(isOperator(arrays[i])) {
				if(temp!=-1) {
					nums.push(temp);
					temp=-1;
				}
					
				if(!ops.isEmpty()) {
					char operator=ops.peek();
					if(operator=='*') {
						int num1=nums.pop();
						int num2=nums.pop();
						nums.push(num1*num2);
						ops.pop();
						i--;
					}else if(operator=='/') {
						int num1=nums.pop();
						int num2=nums.pop();
						nums.push(num2/num1);
						ops.pop();
						i--;
					}else if((arrays[i]=='+'||arrays[i]=='-')&&operator=='+') {
						int num1=nums.pop();
						int num2=nums.pop();
						nums.push(num1+num2);
						ops.pop();
						i--;
					}else if((arrays[i]=='+'||arrays[i]=='-')&&operator=='-') {
						int num1=nums.pop();
						int num2=nums.pop();
						nums.push(num2-num1);
						ops.pop();
						i--;
					}else
						ops.push(arrays[i]);
					
				}else
					ops.push(arrays[i]);
			}
		}
		if(temp!=-1)
			nums.push(temp);
		
		if(!ops.isEmpty()&&ops.peek()=='*') {
			char c=ops.pop();
			int num1=nums.pop();
			int num2=nums.pop();
			nums.push(num1*num2);
		}
		if(!ops.isEmpty()&&ops.peek()=='/') {
			char c=ops.pop();
			int num1=nums.pop();
			int num2=nums.pop();
			nums.push(num2/num1);
		}
		if(!ops.isEmpty()&&ops.peek()=='+') {
			char c=ops.pop();
			int num1=nums.pop();
			int num2=nums.pop();
			nums.push(num1+num2);
		}
		if(!ops.isEmpty()&&ops.peek()=='-') {
			char c=ops.pop();
			int num1=nums.pop();
			int num2=nums.pop();
			nums.push(num2-num1);
		}
		
		return nums.pop();
	}
	public boolean isDigit(char c) {
		return (c>='0'&&c<='9');
	}
	public boolean isOperator(char c) {
		return (c=='+'||c=='-'||c=='*'||c=='/');
	}
}
