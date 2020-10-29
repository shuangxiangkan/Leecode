package dynamicProgramming;

public class P64 {
	public static void main(String[] args) {
		int[][] grid= {{1,3,1},
				  {1,5,1},
				  {4,2,1}};
		System.out.println(minPathSum(grid));
	}
	public static int minPathSum(int[][] grid) {
		int[][] dp=new int[grid.length][grid[0].length];
		//初始化
		//行初始化
		int temp=0;
		for(int i=0;i<grid[0].length;i++) {
			temp+=grid[0][i];
			dp[0][i]=temp;
		}
		temp=0;	
		//列初始化
		for(int i=0;i<grid.length;i++) {
			temp+=grid[i][0];
			dp[i][0]=temp;
		}
			
		for(int i=1;i<grid.length;i++){
			for(int j=1;j<grid[0].length;j++) {
				dp[i][j]=Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);
			}
		}
		return dp[grid.length-1][grid[0].length-1];
    }
}
