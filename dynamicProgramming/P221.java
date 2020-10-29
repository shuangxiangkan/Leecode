package dynamicProgramming;

public class P221 {
	public static void main(String[] args) {
//		char[][] matrix= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		char[][] matrix= {{'0','0','0'},{'0','0','0'},{'0','0','0'},{'0','0','0'}};
		System.out.println(maximalSquare(matrix));
	}
	public static int maximalSquare(char[][] matrix) {
		if(matrix.length==0||matrix==null)
			return 0;
		int[][] labels=new int[matrix.length][matrix[0].length];
		int max=0;
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]=='1') {
				labels[i][0]=1;
				max=1;
			}
				
		}
		for(int j=0;j<matrix[0].length;j++) {
			if(matrix[0][j]=='1') {
				labels[0][j]=1;
				max=1;
			}	
		}
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				if(matrix[i][j]=='1') {
					int min=Math.min(labels[i-1][j], labels[i][j-1]);
					min=Math.min(min, labels[i-1][j-1]);
					labels[i][j]=min+1;
				}else {
					labels[i][j]=0;
				}
				if(labels[i][j]>max)
					max=labels[i][j];
			}
		}
		return (int)Math.pow(max, 2);
    }
}
