package binarySearch;

public class P441 {
	public static void main(String[] args) {
		int n=1804289383;
		P441 p=new P441();
		System.out.println(p.arrangeCoins(n));
	}
	public int arrangeCoins(int n) {
		int a=(int)Math.sqrt(n);
		long i=a;
		for(i=a;i<n;i++) {
			long sum=(1+i)*i/2;
			long r=n-sum;
			if(r<=i) {
				break;
			}	
		}
		return (int)i;
    }
}
