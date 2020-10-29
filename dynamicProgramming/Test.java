package dynamicProgramming;

//import java.util.Scanner;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
		List<Integer> list=eventualSafeNodes(graph);
		for (Integer item : list) {
			System.out.print(item+"\t");
		}
	}
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> list=new ArrayList<Integer>();
		int len=graph.length;
		int[] color=new int[len];
		for(int i=0;i<len;i++) {
			if(judge(color, i, graph))
				list.add(i);
		}
		return list;
	}
	public static boolean judge(int[] color,int node,int[][] graph) {
		if(color[node]>0)
			return color[node]==2;
		color[node]=1;
		for (int item : graph[node]) {
			if(color[item]==2)
				continue;
			if(color[item]==1||!judge(color, item, graph))
				return false;
		}
		color[node]=2;
		return true;
	}
	
}
