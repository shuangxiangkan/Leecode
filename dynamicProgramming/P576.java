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
		//���Ͻ�
		else if(i-1<0&&j-1<0&&i+1<=m-1&&j+1<=n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//���Ͻ�
		else if(i-1<0&&j-1>=0&&i+1<=m-1&&j+1>n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j-1))%((int)Math.pow(10, 9)+7);
		//���½�
		else if(i-1>=0&&j-1<0&&i+1>m-1&&j+1<=n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//���½�
		else if(i-1>=0&&j-1>=0&&i+1>m-1&&j+1>n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i,j-1))%((int)Math.pow(10, 9)+7);
		//�������һ�У�������������
		else if(i-1<0&&j-1>=0&&i+1<=m-1&&j+1<=n-1&&N>=1)
			return (1+findPaths(m,n,N-1,i,j-1)+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//�������һ�У�������������
		else if(i-1>=0&&j-1<0&&i+1<=m-1&&j+1<=n-1&&N>=1)
			return (1+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//�������һ�У�������������
		else if(i-1>=0&&j-1>=0&&i+1>m-1&&j+1<=n-1&&N>=1)
			return (1+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i,j-1)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//�������һ�У�������������
		else if(i-1>=0&&j-1>=0&&i+1<=m-1&&j+1>n-1&&N>=1)
			return (1+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j-1))%((int)Math.pow(10, 9)+7);
		//���м�ģ������ߵ�
		else if(i-1>=0&&j-1>=0&&i+1<=m-1&&j+1<=n-1&&N>=1)
			return (findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i+1,j)+findPaths(m,n,N-1,i,j-1)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//���������������ֻ��һ�л���һ��
		//һ��
		//������Ľ�
		else if(i-1<0&&j-1<0&&i+1>m-1&&j+1<=n-1&&N>=1)
			return (3+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//������Ľ�
		else if(i-1<0&&j-1>=0&&i+1>m-1&&j+1>n-1&&N>=1)
			return (3+findPaths(m,n,N-1,i,j-1))%((int)Math.pow(10, 9)+7);
		//�м�Ľ�
		else if(i-1<0&&j-1>=0&&i+1>m-1&&j+1<=n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i,j-1)+findPaths(m,n,N-1,i,j+1))%((int)Math.pow(10, 9)+7);
		//һ��
		//������Ľ�
		else if(i-1<0&&j-1<0&&i+1<=m-1&&j+1>n-1&&N>=1)
			return (3+findPaths(m,n,N-1,i+1,j))%((int)Math.pow(10, 9)+7);
		//������Ľ�
		else if(i-1>=0&&j-1<0&&i+1>m-1&&j+1>=n-1&&N>=1)
			return (3+findPaths(m,n,N-1,i-1,j))%((int)Math.pow(10, 9)+7);
		//�м�Ľ�
		else if(i-1>=0&&j-1<0&&i+1<=m-1&&j+1>=n-1&&N>=1)
			return (2+findPaths(m,n,N-1,i-1,j)+findPaths(m,n,N-1,i+1,j))%((int)Math.pow(10, 9)+7);
		//1X1
		else if(m==1&&n==1&&N>=1)
			return 4;
		else
			return 0;
    }	
}
