package dfs;

import java.util.ArrayList;

public class P1319 {
	public static void main(String[] args) {
//		int n = 4;
//		int[][] connections = {{0,1},{0,2},{1,2}};
		
//		int n = 6;
//		int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
		
		int n = 5;
		int[][] connections = {{0,1},{0,2},{3,4},{2,3}};
		
//		int n = 6;
//		int[][] connections = {{0,1},{0,2},{0,3},{1,2}};
		
//		int n=8;
//		int[][] connections= {{0,2},{2,7},{5,7},{2,6},{1,3},{4,6},{1,2}};
		
//		int n=8;
//	    int[][] connections= {{0,6},{2,3},{2,6},{2,7},{1,7},{2,4},{3,5},{0,2}};
				
		P1319 p=new P1319();
		System.out.println(p.makeConnected(n, connections));
	}
	
	public int makeConnected(int n,int[][] connections) {
		if(n-1>connections.length)
			return -1;
		int count=0;
		int[] father=new int[n];
		for(int i=0;i<n;i++)
			father[i]=i;
		for(int i=0;i<connections.length;i++) {
			union(father,connections[i][0],connections[i][1]);
		}
		for(int i=0;i<n;i++)
			if(father[i]==i)
				count++;
		return count-1;
	}
	public int findFather(int[] father,int x) {
		if(father[x]==x)
			return x;
		else
			return findFather(father, father[x]);
	}
	public void union(int[] father,int a,int b) {
		int i=findFather(father,a);
		int j=findFather(father,b);
		if(i!=j)
			father[i]=j;
	}
}
