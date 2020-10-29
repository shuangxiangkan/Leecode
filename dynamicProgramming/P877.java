package dynamicProgramming;

public class P877 {
	public static void main(String[] args) {
		int[] piles= {5,3,4,5};
		System.out.println(stoneGame(piles));
	}
	public static boolean stoneGame(int[] piles) {
		int[][][] dp=new int[piles.length][piles.length][2];
		for(int i=0;i<piles.length;i++) {
			dp[i][i][0]=piles[i];
			dp[i][i][1]=0;
		}
		int n=piles.length;
		for (int l = 2; l <= n; l++) {
	        for (int i = 0; i <= n - l; i++) {
	            int j = l + i - 1;
	            // 先手选择最左边或最右边的分数
	            int left = piles[i] + dp[i+1][j][1];
	            int right = piles[j] + dp[i][j-1][1];
	            // 套用状态转移方程
	            if (left > right) {
	                dp[i][j][0] = left;
	                dp[i][j][1] = dp[i+1][j][0];
	            } else {
	                dp[i][j][0] = right;
	                dp[i][j][1] = dp[i][j-1][0];
	            }
	        }
	    }
		if(dp[0][n-1][0]-dp[0][n-1][1]>0)
			return true;
		else
			return false;
    }
}
