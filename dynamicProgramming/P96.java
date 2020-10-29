package dynamicProgramming;

public class P96 {
	public static void main(String[] args) {
		int n=3;
		System.out.println(numTrees(n));
	}
	public static int numTrees(int n) {
		if(n==0||n==1)
			return 1;
		int[] trees=new int[n+1];
		trees[0]=1;
		trees[1]=1;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				trees[i]+=trees[j-1]*trees[i-j];
			}
		}
		
		return trees[n];
    }
}
