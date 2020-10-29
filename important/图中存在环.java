package important;

import java.util.*;

/*
 * Leecode 802��
 * https://leetcode-cn.com/problems/find-eventual-safe-states/
 */
public class ͼ�д��ڻ� {
	public static void main(String[] args) {
		/*
		 * �����Ŀ��������ʽ�������ģ�graph[0]={1,2}��ʾ�ڵ�0���Ե���ڵ�1�ͽڵ�2
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
