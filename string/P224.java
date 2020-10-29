package string;

import java.util.Stack;

public class P224 {
	public static void main(String[] args) {
//		String s="1 + 1";
//		String s=" 2-1 + 2 ";
		String s="(1+(4+5+2)-3)+(6+8)";
		P224 p=new P224();
		System.out.println(p.calculate(s));
	}
	public int calculate(String s) {
		Stack<Integer> nums=new Stack<>();
		Stack<Character> ops=new Stack<>();
		char[] array=s.toCharArray();
		int temp=-1;
		for(int i=0;i<array.length;i++) {
			if(isDigit(array[i])) {
				if(temp==-1)
					temp=array[i]-'0';
				else {
					temp=temp*10+array[i]-'0';
				}
			}else {
				if(temp!=-1) {
					nums.push(temp);
					temp=-1;
					
				}
				if(idOperator(array[i])) {
					while(!ops.isEmpty()) {
						if(ops.peek()=='(')
							break;
						int num1=nums.pop();
						int num2=nums.pop();
						char operator=ops.pop();
						if(operator=='+'){
							nums.push(num1+num2);
						}
						if(operator=='-') {
							nums.push(num2-num1);
						}
					}
					ops.push(array[i]);
				}
				else {
					if(array[i]=='(')
						ops.push(array[i]);
					if(array[i]==')') {
						while(!ops.isEmpty()) {
							char operator=ops.pop();
							if(operator=='(')
								break;
							int num1=nums.pop();
							int num2=nums.pop();
							if(operator=='+')
								nums.push(num1+num2);
							else
								nums.push(num2-num1);
						}
					}
				}
			}
			
		}
		if(temp!=-1)
			nums.push(temp);
		while(!ops.isEmpty()) {
			char operator=ops.pop();
			int num1=nums.pop();
			int num2=nums.pop();
			if(operator=='+')
				nums.push(num1+num2);
			else
				nums.push(num2-num1);
		}
		
		return nums.pop();
    }
	public boolean isDigit(char c) {
		return (c>='0'&&c<='9');
	}
	public boolean idOperator(char c) {
		return (c=='+'||c=='-');
	}
}
