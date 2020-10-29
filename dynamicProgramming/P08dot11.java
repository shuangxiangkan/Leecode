package dynamicProgramming;

public class P08dot11 {
	public static void main(String[] args) {
		int n=5;
		System.out.println(waysToChange(n));
	}
	public static int waysToChange(int n) {
		int[] dp=new int[n+1];
		int[] coins= {1,5,10,25};
		dp[0]=1;
		for (int coin : coins) {
			for(int i=coin;i<=n;i++) {
				dp[i]=dp[i]+dp[i-coin];
			}
		}
		return dp[n];
    }
}
