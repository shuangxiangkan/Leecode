package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class P16dot19 {
	public static void main(String[] args) {
		int[][] land= {
		  {0,2,1,0},
		  {0,1,0,1},
		  {1,1,0,1},
		  {0,1,0,1}
		  };
		P16dot19 p=new P16dot19();
		int[] results=p.pondSizes(land);
		for (int i : results) {
			System.out.println(i);
		}
	}
	public int[] pondSizes(int[][] land) {
		ArrayList<Integer> list=new ArrayList<>();
		int num=0;
		
		for(int i=0;i<land.length;i++) {
			for(int j=0;j<land[0].length;j++) {
				num=find(land,i,j);
				if(num>0)
					list.add(num);
			}
		}
		int[] results=new int[list.size()];
		for(int i=0;i<list.size();i++)
			results[i]=list.get(i);
		
		Arrays.sort(results);
		return results;
		
    }
	private int find(int[][] land,int i,int j) {
		int num=0;
		if(i<0||i>=land.length||j<0||j>=land[0].length||land[i][j]!=0)
			return num;
		num++;
		land[i][j]=-1;
		num+=find(land,i+1,j);
		num+=find(land,i-1,j);
		num+=find(land,i,j+1);
		num+=find(land,i,j-1);
		num+=find(land,i+1,j+1);
		num+=find(land,i+1,j-1);
		num+=find(land,i-1,j+1);
		num+=find(land,i-1,j-1);
		
		return num;
	}
}
