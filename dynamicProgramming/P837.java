package dynamicProgramming;

public class P837 {
	public static void main(String[] args) {
//		int N = 10, K = 1, W = 10;
//		int N = 6, K = 1, W = 10;
		int N = 21, K = 17, W = 10;
		System.out.println(new21Game(N, K, W));
	}
	public static double new21Game(int N, int K, int W) {
		double[] dp=new double[K+W];
		double s=0;
		for(int i=K;i<dp.length;i++) {
			if(i<=N)
				dp[i]=1;
			else
				dp[i]=0;
			s+=dp[i];
		}
		for(int i=K-1;i>=0;i--) {
			dp[i]=s/W;
			s=s-dp[i+W]+dp[i];
		}
		return dp[0];
    }
}
