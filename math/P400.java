package math;

public class P400 {
	public static void main(String[] args) {
		int n=1000000000;
		P400 p=new P400();
		System.out.println(p.findNthDigit(n));
	}
	public int findNthDigit(int n) {
		if(n>=1&&n<=9)
			return n;
		else if(n>=10&&n<=189) {
			int temp=n-9;
			int digit=9+(int)Math.ceil(temp/2.0);
			int num=temp%2;
			if(num==0)
				return String.valueOf(digit).charAt(1)-'0';
			else
				return String.valueOf(digit).charAt(0)-'0';
		}else {
			n=n-9-90*2;
			long i=100;
			int j=3;
			long sum=189;
			while(n>sum+j*(i*10-i)) {
				sum=sum+j*(i*10-i);
				i=i*10;
				j++;
			}
			int nl=(int)(n-sum+189);
			int digit=(int)(i-1+(int)Math.ceil(1.0*nl/j));
			int num=nl%j;
			if(num==0)
				return String.valueOf(digit).charAt(j-1)-'0';
			else
				return String.valueOf(digit).charAt((num-1))-'0';
		}
    }
}
