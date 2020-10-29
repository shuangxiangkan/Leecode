package array;

public class P1277 {
	public static void main(String[] args) {
//		int[][] matrix= {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		int[][] matrix= {{1,0,1},{1,1,0},{1,1,0}};
		System.out.println(countSquares(matrix));
	}
	public static int countSquares(int[][] matrix) {
		int count=0;
		int row=matrix.length;
		int col=matrix[0].length;
		int[][] A=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(i==0||j==0)
					A[i][j]=matrix[i][j];
				else if(matrix[i][j]==0)
					A[i][j]=0;
				else {
					int min=Math.min(A[i][j-1], A[i-1][j]);
					A[i][j]=Math.min(min, A[i-1][j-1])+1;
				}	
				count+=A[i][j];
			}
		}
		
		return count;
    }
}
