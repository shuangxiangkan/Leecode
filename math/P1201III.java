package math;

public class P1201III {
	public static void main(String[] args) {
		P1201III p=new P1201III();
		int n=1000000000;
		int a=2;
		int b=168079517;
		int c=403313907;
//		int n = 5;
//		int a = 2;
//		int b = 11;
//		int c = 13;
//		int n = 1000000000;
//		int a = 2;
//		int b = 217983653;
//		int c = 336916467;
		System.out.println(p.nthUglyNumber(n, a, b, c));
	}
	public long leastCommonMultiple(long a,long b) {
		long product=a*b;
		long temp=b;
		while(b!=0) {
			temp=b;
			b=a%b;
			a=temp;
		}
		return product/a;
	}
	public int nthUglyNumber(int n, int a, int b, int c) {
		long ab=leastCommonMultiple(a, b);
		long ac=leastCommonMultiple(a, c);
		long bc=leastCommonMultiple(b, c);
		long abc=leastCommonMultiple(ab, c);
		long left=1;
		long right=2000000000;
		while(left<right) {
			long mid=(left+right)/2;
//			int mid=left+(right-left)/2;
			long num=mid/a+mid/b+mid/c-mid/ab-mid/ac-mid/bc+mid/abc;
			if(num>n) {
				right=mid-1;
			}else if(num<n) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return (int)right;
	}
}
