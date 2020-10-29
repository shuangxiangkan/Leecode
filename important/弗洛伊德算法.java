package important;

public class ���������㷨 {
	public static void main(String[] args) {
		//�����ʽ{0,1,600}��ʾ�ڵ�0���ڵ�1�ľ�����600
		int[][] times= {{0,1,600},{1,2,500},{0,2,1300}};
		int N=3;
		int A=0;
		int B=2;
		System.out.println(networkDelayTime(N, times, A, B));
	}
	//�ڵ����Ǵ�1��N�ģ����A�ڵ㵽B�ڵ�����·��
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
