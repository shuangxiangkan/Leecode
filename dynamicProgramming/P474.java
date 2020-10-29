package dynamicProgramming;

public class P474 {
	public static void main(String[] args) {
		String[] strs={"10", "0001", "111001", "1", "0"};
		int m=5;
		int n=3;
		int ans=findMaxForm(strs, m, n);
		System.out.println(ans);
	}
	public static int findMaxForm(String[] strs, int m, int n) {
		int len=strs.length;
		int[][][] dp=new int[len+1][m+1][n+1];
		for(int i=1;i<=len;i++) {
			int[] cnt=countzeroesones(strs[i-1]);
			for(int j=0;j<=m;j++) {
				for(int k=0;k<=n;k++) {
					int zero=cnt[0];
					int one=cnt[1];
					if(j>=zero&&k>=one) {
						dp[i][j][k]=Math.max(dp[i-1][j][k], dp[i-1][j-zero][k-one]+1);
					}else {
						dp[i][j][k]=dp[i-1][j][k];
					}
				}
			}
		}
		return dp[len][m][n];
    }
	public static int[] countzeroesones(String s) {
		int[] c=new int[2];
		for(int i=0;i<s.length();i++) {
			c[s.charAt(i)-'0']++;
		}
		return c;
	}
}
