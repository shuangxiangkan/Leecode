package string;

import java.util.Stack;

public class P16dot26 {
	public static void main(String[] args) {
//		String s="3+2*2";
//		String s="3+1+4";
//		String s=" 3/2 ";
//		String s=" 3+5 / 2 ";
//		String s="2-3+4";
//		String s="14-3/2";
		String s="1*2-3/4+5*6-7*8+9/10";
		System.out.println(calculate(s));
	}
	public static boolean judge(char a,char b) {
		//判断符号a和b的优先级,+,-,*/
		if((a=='*'||a=='/')&&(b=='*'||b=='/'))
			return false;
		else if((a=='+'||a=='-')&&(b=='+'||b=='-'))
			return false;
		else if((a=='*'||a=='/')&&(b=='+'||b=='-'))
			return true;
		else
			return false;
	}
	public static int compute(int num1,int num2,char c) {
		if(c=='+')
			return num1+num2;
		if(c=='-')
			return num1-num2;
		if(c=='*')
			return num1*num2;
		else
			return (int)num1/num2;
	}
	public static int calculate(String s) {
		Stack<Integer> nums=new Stack<>();
		Stack<Character> operators=new Stack<>();
		int result=0;
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i)!=' ') {
				if(Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
				}else {
					int num=Integer.parseInt(sb.toString());
					nums.push(num);
					sb.delete(0, sb.length());
					char a=s.charAt(i);
					if(operators.isEmpty())
						operators.push(a);
					else {
						char b=operators.peek();
						if(judge(a, b)) 
							operators.push(a);
						else {
							int num1=nums.pop();
							int num2=nums.pop();
							char ope=operators.pop();
							operators.push(a);
							nums.push(compute(num2,num1,ope));
						}
					}
				}
			}
		}
		if(!(sb.length()==0)) {
			int num=Integer.parseInt(sb.toString());
			nums.push(num);
		}
		if(operators.size()==1) {
			int num1=nums.pop();
			int num2=nums.pop();
			char ope=operators.pop();
			int r=compute(num2,num1,ope);
			nums.push(r);
		}
		if(operators.size()==2) {
			int num1=nums.pop();
			int num2=nums.pop();
			int num3=nums.pop();
			char ope1=operators.pop();
			char ope2=operators.pop();
			if(judge(ope1, ope2)) {
				int inter=compute(num2,num1,ope1);
				return compute(num3,inter,ope2);
			}
			int inter=compute(num3,num2,ope2);
			return compute(inter,num1,ope1);
			
		}
		result=nums.pop();
		return result;
    }
}
