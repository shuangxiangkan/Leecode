package array;

public class P1010 {
	public static void main(String[] args) {
		int[] time= {60,60,60};
		System.out.println(numPairsDivisibleBy60(time));
	}
	public static int numPairsDivisibleBy60(int[] time) {
		int count=0;
		int[] remainders=new int[60];
		for(int i=0;i<time.length;i++) {
			int re=time[i]%60;
			remainders[re]++;
		}
		//处理余数为0的情况
		count+=remainders[0]*(remainders[0]-1)/2;
		//同上，处理余数为30的情况
		count+=remainders[30]*(remainders[30]-1)/2;
		//处理剩余余数的情况
		for(int i=1, j=59;i<j;i++,j--) {
			count+=remainders[i]*remainders[j];
		}
		return count;
	}
}
