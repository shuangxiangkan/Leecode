package important;

import java.util.*;

/*
 * Leecode 802题
 * https://leetcode-cn.com/problems/find-eventual-safe-states/
 */
public class 图中存在环 {
	public static void main(String[] args) {
		/*
		 * 这个题目的输入形式是这样的，graph[0]={1,2}表示节点0可以到达节点1和节点2
		 */
		int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
		System.out.println(eventualSafeNodes(graph));
	}
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int len=graph.length;
		int[] color=new int[len];
		ArrayList<Integer> alist=new ArrayList<>();
		for(int i=0;i<len;i++) {
			if(dfs(i,color,graph))
				alist.add(i);
		}
		return alist;
	}
	public static boolean dfs(int i,int[] color,int[][] graph) {
		if(color[i]>0)
			return color[i]==2;
		
		color[i]=1;
		for(int item:graph[i]) {
			if(color[item]==2)
				continue;
			if(color[item]==1||!dfs(item,color,graph))
				return false;
		}
		color[i]=2;
		return true;
	}
}
