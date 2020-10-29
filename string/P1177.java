package string;

import java.util.ArrayList;
import java.util.List;

public class P1177 {
	public static void main(String[] args) {
//		String s = "hunu";
		String s="abcda";
		int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
		
//		int[][] queries = {{0,3,1}};
		List<Boolean> list=canMakePaliQueries(s, queries);
		for (Boolean item : list) {
			System.out.println(item);
		}
	}
	public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> list=new ArrayList<Boolean>();
		int[][] counts=new int[s.length()+1][26];
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			System.arraycopy(counts[i], 0, counts[i+1], 0, 26);
			counts[i+1][c-'a']++;
		}
		for (int[] q : queries) {
			int start=q[0],end=q[1],k=q[2],length=end-start+1;
			int[] count=new int[26];
			for(int i=0;i<26;i++) {
				count[i]=counts[end+1][i]-counts[start][i];	
			}
			int sum=0;
			for (int c : count) {
				if(c%2==1)
					sum++;
			}
			if(length%2==1)
				sum--;
			if(sum>k*2)
				list.add(false);
			else
				list.add(true);
		}
		
		return list;
    }
}
