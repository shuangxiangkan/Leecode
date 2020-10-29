package stack;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int m=scan.nextInt();
		int n=scan.nextInt();
		int[][] a=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=scan.nextInt();
			}
		}
		Test t=new Test();
		System.out.println(t.MAX(0,m, n, a));
		
	}
	public int MAX(int p,int m,int n,int[][] a) {
		if(p>=m||n==0)
			return 0;
		int max=a[p][0];
		for(int i=0;i<n;i++) {
			int sum=a[p][i]+MAX(p+1,m,n-i-1,a);
			if(sum>max)
				max=sum;
		}
		return max;
	}
}
