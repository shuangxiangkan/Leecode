package dynamicProgramming;

public class P718 {
	public static void main(String[] args) {
		int[] A= {1,2,3,2,1};
		int[] B= {3,2,1,4,7};
		System.out.println(findLength(A, B));
				
	}
	public static int findLength(int[] A, int[] B) {
		int max=0;
		int[][] labels=new int[A.length+1][B.length+1];
		for(int i=A.length-1;i>=0;i--) {
			for(int j=B.length-1;j>=0;j--) {
				if(A[i]==B[j]) {
					labels[i][j]=labels[i+1][j+1]+1;
					max=Math.max(max, labels[i][j]);
				}
			}
		}
		return max;
    }
}
