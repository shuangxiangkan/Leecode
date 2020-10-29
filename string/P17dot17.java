package string;

import java.util.ArrayList;
import java.util.List;

public class P17dot17 {
	public static void main(String[] args) {
		String big = "mississippi";
		String[] smalls = {"is","ppi","hi","sis","i","ssippi"};
//		String big =       "aaaa";
//		String[] smalls = {"aa"};
		int[][] results=multiSearch(big, smalls);
		for(int i=0;i<results.length;i++) {
			for(int j=0;j<results[i].length;j++)
				System.out.print(results[i][j]+" ");
			System.out.println();
		}
	}
	public static int[][] multiSearch(String big, String[] smalls) {
		int[][] result=new int[smalls.length][];
		List<Integer> list=new ArrayList<Integer>();
		
		for (int i=0;i<smalls.length;i++) {
			if(smalls[i].length()>0) {
				list.clear();
				int index=-1;
				for(int k=0;k<big.length()-smalls[i].length()+1;k++) {
					
					if(big.substring(k).startsWith(smalls[i]))
						list.add(k);
				}
				result[i]=new int[list.size()];
				for(int j=0;j<result[i].length;j++)
					result[i][j]=list.get(j);
			}else {
				result[i]=new int[0];
			}
			
		}
		return result;
    }
}
