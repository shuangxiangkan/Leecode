package math;

public class POffer67 {
	public static void main(String[] args) {
//		String str="42";
//		String str="   -42";
//		String str="4193 with words";
//		String str="words and 987";
//		String str="-91283472332";
//		String str="-";
//		String str="+1";
//		String str="+-2";
		String str="9223372036854775808";
		POffer67 p=new POffer67();
		System.out.println(p.strToInt(str));
	}
	public boolean isDigit(char c) {
		return (c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9');
	}
	public int strToInt(String str) {
		str=str.trim();
		if(str.length()==0)
			return 0;
		char[] array=str.toCharArray();
		boolean negative=false;
		long temp=-1;
		for (int i=0;i<array.length;i++) {
			if(i==0&&array[i]=='+');
			else if(i==0&&array[i]=='-')
				negative=true;
			else if(isDigit(array[i])) {
				if(temp==-1)
					temp=array[i]-'0';
				else {
					temp=temp*10+array[i]-'0';
					if(temp>Integer.MAX_VALUE)
						break;
				}
			}else
				break;
		}
		
		if(negative) {
			if(temp==-1)
				return 0;
			else if((0-temp)<Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			else
				return (int)(0-temp);
		}else if(temp>Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		else if(temp==-1)
			return 0;
		else
			return (int)temp;
		
    }
}
