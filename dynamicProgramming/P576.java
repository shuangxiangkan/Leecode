package dynamicProgramming;

public class P576 {
	public static void main(String[] args) {
//		int m = 2, n = 2, N = 2, i = 0, j = 0;
//		int m = 1, n = 3, N = 3, i = 0, j = 1;
//		int m = 3, n = 2, N = 5, i = 1, j = 1;
//		int m=4,n=5,N=8,i=3,j=2;
//		int m = 3, n = 1, N = 5, i = 2, j = 0;
		int m = 8, n = 7, N = 16, i = 1, j = 5;//102984580
		System.out.println(findPaths(m, n, N, i, j));
	}
	public static int findPaths(int m, int n, int N, int i, int j) {
		if(N<=0)
			return 0;
		//左上角
		else if(i-1<0&&j-1<0&&i+1<=m-1&&j+1<=n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//右上角
		else if(i-1<0&&j-1>=0&&i+1<=m-1&&j+1>n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j-1))%((int)Math.pow(10, 9)+7);
		//左下角
		else if(i-1>=0&&j-1<0&&i+1>m-1&&j+1<=n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//右下角
		else if(i-1>=0&&j-1>=0&&i+1>m-1&&j+1>n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i,j-1))%((int)Math.pow(10, 9)+7);
		//最上面的一行，不包括两个角
		else if(i-1<0&&j-1>=0&&i+1<=m-1&&j+1<=n-1&&N>=1)
			return (1+findPaths(m,n,N-1,i,j-1)+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//最左面的一行，不包括两个角
		else if(i-1>=0&&j-1<0&&i+1<=m-1&&j+1<=n-1&&N>=1)
			return (1+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//最下面的一行，不包括两个角
		else if(i-1>=0&&j-1>=0&&i+1>m-1&&j+1<=n-1&&N>=1)
			return (1+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i,j-1)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//最右面的一行，不包括两个角
		else if(i-1>=0&&j-1>=0&&i+1<=m-1&&j+1>n-1&&N>=1)
			return (1+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j-1))%((int)Math.pow(10, 9)+7);
		//最中间的，不靠边的
		else if(i-1>=0&&j-1>=0&&i+1<=m-1&&j+1<=n-1&&N>=1)
			return (findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j-1)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//下面是特殊情况，只有一行或者一列
		//一行
		//最左面的角
		else if(i-1<0&&j-1<0&&i+1>m-1&&j+1<=n-1&&N>=1)
			return (3+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//最右面的角
		else if(i-1<0&&j-1>=0&&i+1>m-1&&j+1>n-1&&N>=1)
			return (3+findPaths(m,n,N-1,i,j-1))%((int)Math.pow(10, 9)+7);
		//中间的角
		else if(i-1<0&&j-1>=0&&i+1>m-1&&j+1<=n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i,j-1)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//一列
		//最上面的角
		else if(i-1<0&&j-1<0&&i+1<=m-1&&j+1>n-1&&N>=1)
			return (3+findPaths(m,n,N-1,i+1,j))%((int)Math.pow(10, 9)+7);
		//最下面的角
		else if(i-1>=0&&j-1<0&&i+1>m-1&&j+1>=n-1&&N>=1)
			return (3+findPaths(m,n,N-1,i-1,j))%((int)Math.pow(10, 9)+7);
		//中间的角
		else if(i-1>=0&&j-1<0&&i+1<=m-1&&j+1>=n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i+1,j))%((int)Math.pow(10, 9)+7);
		//1X1
		else if(m==1&&n==1&&N>=1)
			return 4;
		else
			return 0;
    }	
}
