package dfs;

public class P1254 {
	public static void main(String[] args) {
//		int[][] grid = {
//				{1,1,1,1,1,1,1,0},
//				{1,0,0,0,0,1,1,0},
//				{1,0,1,0,1,1,1,0},
//				{1,0,0,0,0,1,0,1},
//				{1,1,1,1,1,1,1,0}};
		
//		int[][] grid = {
//				{1,1,1},
//				{0,0,1},
//				{0,1,1}};
			
		int[][] grid= {
				{0,0,1,1,0,1,0,0,1,0},
				{1,1,0,1,1,0,1,1,1,0},
				{1,0,1,1,1,0,0,1,1,0},
				{0,1,1,0,0,0,0,1,0,1},
				{0,0,0,0,0,0,1,1,1,0},
				{0,1,0,1,0,1,0,1,1,1},
				{1,0,1,0,1,1,0,0,0,1},
				{1,1,1,1,1,1,0,0,0,0},
				{1,1,1,0,0,1,0,1,0,1},
				{1,1,1,0,1,1,0,1,1,0}};
		
		P1254 p=new P1254();
		int result=p.closedIsland(grid);
		System.out.println(result);
	}
	public boolean find(int[][] grid,int i,int j) {
		if(i<0||i>=grid.length||j<0||j>=grid[0].length)
			return false;
		if(grid[i][j]==1)
			return true;
		grid[i][j]=1;
		boolean flag1=find(grid,i+1,j);
		boolean flag2=find(grid,i-1,j);
		boolean flag3=find(grid,i,j+1);
		boolean flag4=find(grid,i,j-1);
		return flag1&&flag2&&flag3&&flag4;
	}
	public int closedIsland(int[][] grid) {
		int result=0;
		for(int i=0;i<grid.length;i++) {
			boolean temp=false;
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==0) {
					temp=find(grid,i,j);
					if(temp) {
						result++;
					}
				}
			}
		}
		return result;
    }
}
