package graph;

import java.util.*;

public class P802 {
	public static void main(String[] args) {
		int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
		List<Integer> list=eventualSafeNodes(graph);
		for (Integer item : list) {
			System.out.print(item+"\t");
		}
	}
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int N=graph.length;
		int[] color=new int[N];
		List<Integer> ans=new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			if(dfs(i,color,graph))
				ans.add(i);
		}
		return ans;
    }
	//colors:WHITE 0,GRAY 1,BLACK 2;
	public static boolean dfs(int node,int[] color,int[][] graph) {
		if(color[node]>0)
			return color[node]==2;
		
		color[node]=1;
		for(int nei:graph[node]) {
			if(color[node]==2)
				continue;
			if((color[nei]==1)||!dfs(nei,color,graph))
				return false;
		}
		
		color[node]=2;
		return true;
	}
	
}
