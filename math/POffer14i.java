package math;

public class POffer14i {
	public static void main(String[] args) {
		int n=10;
		POffer14i p=new POffer14i();
		System.out.println(p.cuttingRope(n));
	}
	public int cuttingRope(int n) {
		if(n<2)
			return n;
		if(n==2)
			return 1;
		int[] dp=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		int max=0;
		for(int i=3;i<=n;i++) {
			max=0;
			for(int j=1;j<=i-1;j++) {
				if(dp[j]*dp[i-j]>max)
					max=dp[j]*dp[i-j];
			}
			if(max>i)
				dp[i]=max;
			else
				dp[i]=i;
			
		}
		if(max>n)
			return dp[n];
		else
			return max;
    }
}
