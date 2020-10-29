package binarySearch;

public class P1292 {
	public static void main(String[] args) {
		int[][] mat = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
		int threshold = 4;
		P1292 p=new P1292();
		System.out.println(p.maxSideLength(mat, threshold));
	}
	public int maxSideLength(int[][] mat, int threshold) {
		int m=mat.length;
		int n=mat[0].length;
		int[][] dp=new int[m+1][n+1];
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j]=mat[i-1][j-1]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
			}
		}
		int ans=0;
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				for(int k=ans;i+k<=m&&j+k<=n;) {
					int temp=dp[i+k][j+k]-dp[i-1][j+k]-dp[i+k][j-1]+dp[i-1][j-1];
					if(temp<=threshold) {
						ans++;
						k++;
					}else
						break;
				}
			}
		}
		return ans;
    }
}
