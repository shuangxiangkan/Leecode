package dynamicProgramming;

public class P576II {
	public static void main(String[] args) {
//		int m = 2, n = 2, N = 2, i = 0, j = 0;
//		int m = 1, n = 3, N = 3, i = 0, j = 1;
//		int m = 3, n = 2, N = 5, i = 1, j = 1;
//		int m=4,n=5,N=8,i=3,j=2;
//		int m = 3, n = 1, N = 5, i = 2, j = 0;
//		int m = 8, n = 7, N = 16, i = 1, j = 5;//102984580
//		int m = 10, n = 10, N = 0, i = 5, j = 5;
		int m = 8, n = 50, N = 23, i = 5, j = 26;
		System.out.println(findPaths(m, n, N, i, j));
	}
	public static int findPaths(int m, int n, int N, int i, int j) {
		if(m<=0||n<=0||N<=0)
			return 0;
		int[][][] dp=new int[N+1][m][n];
		int mod=(int)Math.pow(10, 9)+7;
		//第一步初始化，
		//初始化左右两边的格子
		for(int row=0;row<m;row++) {
			dp[1][row][0]+=1;
			dp[1][row][n-1]+=1;
		}
		//初始化上下两边的格子
		for(int col=0;col<n;col++) {
			dp[1][0][col]+=1;
			dp[1][m-1][col]+=1;
		}
		
		int[] mx= {-1,1,0,0};
		int[] my= {0,0,-1,1};
		for(int step=2;step<=N;step++) {
			for(int row=0;row<m;row++) {
				for(int col=0;col<n;col++) {
					for(int move=0;move<4;move++) {
						int x=row+mx[move];
						int y=col+my[move];
						if(x<0||x>m-1||y<0||y>n-1)
							continue;
						dp[step][row][col]+=dp[step-1][x][y];
						dp[step][row][col]=dp[step][row][col]%mod;
					}
					
				}
			}
		}
		int sum=0;
		for(int step=1;step<=N;step++) {
			sum+=dp[step][i][j];
			sum=sum%mod;
		}
		return sum%mod;
	}
}
