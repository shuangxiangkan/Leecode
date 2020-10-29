package string;

public class P91 {
//	char[] letters= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
//	int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
	public static void main(String[] args) {
//		String s="00";
//		String s="12";
//		String s="226";
//		String s="012";
//		String s="100";
//		String s="101";
		String s="110";
		System.out.println(numDecodings(s));
	}
	
	public static int numDecodings(String s) {
		int[] dp=new int[s.length()+1];
		int a=Integer.parseInt(s.substring(0,1));
		if(a==0)
			return 0;
		else if(a!=0&&s.length()==1)
			return 1;
		dp[0]=1;
		int b=Integer.parseInt(s.substring(0,2));
		if(b%10==0&&b/10>2)
			return 0;
		if(b%10==0||b>=27) {
			dp[1]=1;
		}else
			dp[1]=2;
		for(int i=2;i<s.length();i++) {
			int num1=Integer.parseInt(s.substring(i,i+1));
			int num2=Integer.parseInt(s.substring(i-1,i+1));
			if(num2%10==0&&num2/10>2)
				return 0;
			else if(num1==0&&(num2/10==1||num2/10==2))
				dp[i]=dp[i-2];
			else if(num1==0)
				return 0;
			else if(num1!=0&&num2>26)
				dp[i]=dp[i-1];
			else if(num1==num2)
				dp[i]=dp[i-1];
			else if(num1!=0&&num2>=1&&num2<=26)
				dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[s.length()-1];
	}
}
