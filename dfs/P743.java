package dfs;

import java.util.Arrays;

public class P743 {
	public static void main(String[] args) {
//		int[][] times = {{2,1,1},{2,3,1},{3,4,1},{1,5,3}};
//		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//		int N = 4;
//		int K = 2;
		
		int[][] times = {{1,2,1},{2,3,2}};
		int N=3;
		int K=1;
		
//		int[][] times = {{1,2,1},{2,3,2},{1,3,2}};
//		int N=3;
//		int K=1;
		P743 p=new P743();
		System.out.println(p.networkDelayTime(times, N, K));
	}

    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph=new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=N;j++) {
        		graph[i][j]=-1;
        	}
        }
        for (int[] time : times) {
			graph[time[0]][time[1]]=time[2];
		}
        int[] distance=new int[N+1];
        Arrays.fill(distance, -1);
        for(int i=1;i<=N;i++)
        	distance[i]=graph[K][i];
        
        distance[K]=0;
        
        boolean[] visited=new boolean[N+1];
        visited[K]=true;
        for(int i=1;i<=N-1;i++) {
        	int minDistance=Integer.MAX_VALUE;
        	int minIndex=1;
        	for(int j=1;j<=N;j++) {
        		if(!visited[j]&&distance[j]!=-1&&distance[j]<minDistance) {
        			minDistance=distance[j];
        			minIndex=j;
        		}
        	}
        	
        	visited[minIndex]=true;
        	
        	
        	for(int j=1;j<=N;j++) {
        		if(graph[minIndex][j]!=-1) {
        			if(distance[j]!=-1) {
        				distance[j]=Math.min(distance[j], distance[minIndex]+graph[minIndex][j]);
        			}else
        				distance[j]=graph[minIndex][j]+graph[minIndex][j];
        		}
        	}
        }
        
        int maxDistance=0;
        for(int i=1;i<=N;i++) {
        	if(distance[i]==-1)
        		return -1;
        	maxDistance=Math.max(maxDistance, distance[i]);
        }
        return maxDistance;
    }
}
