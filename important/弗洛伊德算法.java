package important;

public class 弗洛伊德算法 {
	public static void main(String[] args) {
		//输入格式{0,1,600}表示节点0到节点1的距离是600
		int[][] times= {{0,1,600},{1,2,500},{0,2,1300}};
		int N=3;
		int A=0;
		int B=2;
		System.out.println(networkDelayTime(N, times, A, B));
	}
	//节点标记是从1到N的，求从A节点到B节点的最短路径
	public static int networkDelayTime(int N,int[][] times,int A,int B) {
		int[][] graph=new int[N+1][N+1];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				graph[i][j]=i==j?0:-1;
			}
		}
		for(int[] time:times)
			graph[time[0]][time[1]]=time[2];
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(graph[i][k]!=-1&&graph[k][j]!=-1) {
						if(graph[i][j]!=-1) {
							graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
						}else {
							graph[i][j]=graph[i][k]+graph[k][j];
						}
					}
				}
			}
		}
		return graph[A][B];
	}
}
