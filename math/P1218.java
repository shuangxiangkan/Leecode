package math;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class P1218 {
	public static void main(String[] args) {
//		int[] arr= {1,2,3,4};
//		int difference=1;
//		int[] arr= {1,3,5,7};
//		int difference=1;
//		int[] arr= {1,5,7,8,5,3,4,2,1,1};
//		int difference=-2;
		int[] arr= {-6,6,-8,0,7,-8,5,-7,10,-10};
		int difference=-6;
		P1218 p=new P1218();
		System.out.println(p.longestSubsequence(arr, difference));
		
	}
	public int longestSubsequence(int[] arr, int difference) {
		int result=1;
		Map<Integer, ArrayList<Integer>> map=new LinkedHashMap<>();
		int k=0;
		ArrayList<Integer> alist;
		for (int i : arr) {
			
			if(map.keySet().contains(i)) {
				alist=map.get(i);
				alist.add(k++);
				map.put(i, alist);
			}
			else {
				alist=new ArrayList<>();
				alist.add(k++);
				map.put(i, alist);
			}
				
		}
		int[] dp=new int[arr.length];
		for(int i=0;i<dp.length;i++)
			dp[i]=1;
		
		for(int j=0;j<arr.length;j++) {
			int next=arr[j]+difference;
			if(map.keySet().contains(next)) {
				ArrayList<Integer> indexs=map.get(next);
				for (Integer index : indexs) {
					if(index>j)
						dp[index]=dp[j]+1;
				}
			}
		}
		int max=1;
		for(int i=0;i<dp.length;i++) {
			if(max<dp[i])
				max=dp[i];
		}
		return max;
    }
}
