package dynamicProgramming;

public class P1139 {
	public static void main(String[] args) {
//		int[][] grid= {{1,1,1},{1,0,1},{1,1,1}};
//		int[][] grid= {{1,1,0,0}};
		int[][] grid= {{1,1,0},{1,0,1},{1,1,1},{1,1,1},{1,1,1},{1,1,0},{1,1,1},{1,1,0}};
		System.out.println(largest1BorderedSquare(grid));
	}
	public static int largest1BorderedSquare(int[][] grid) {
		if(grid.length==0)
			return 0;
		int[][][] labels=new int[grid.length+1][grid[0].length+1][2];
		for(int i=grid.length-1;i>=0;i--) {
			for(int j=grid[0].length-1;j>=0;j--) {
				if(grid[i][j]==1) {
					//ср╠ъ
					labels[i][j][0]=labels[i][j+1][0]+1;
					//об╠ъ
					labels[i][j][1]=labels[i+1][j][1]+1;
				}
			}
		}
		
		//еп╤о
		int len=Math.min(grid.length, grid[0].length);
		while(len>0) {
			for(int i=0;i<=grid.length-len;i++) {
				for(int j=0;j<=grid[0].length-len;j++) {
					if(labels[i][j][0]>=len&&
					   labels[i][j][1]>=len&&
					   labels[i][j+len-1][1]>=len&&
					   labels[i+len-1][j][0]>=len) {
						return (int)Math.pow(len, 2);
					}
				}
			}
			len--;
		}
		return (int)Math.pow(len, 2);
    }
}
