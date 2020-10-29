package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		Test t=new Test();
		int[] ans=t.topKFrequent(nums, k);
		for(int i=0;i<ans.length;i++)
			System.out.print(ans[i]+" ");
	}
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int num:nums) {
			int value=map.getOrDefault(num, 0)+1;
			map.put(num, value);
		}
		ArrayList<int[]> alist=new ArrayList<>();
		int[][] a=new int[map.size()][2];
		
		for(int key:map.keySet()) {
			alist.add(new int[] {key,map.get(key)});
		}
		Collections.sort(alist, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				// TODO Auto-generated method stub
				return b[1]-a[1];
			}
		});
		int[] ans=new int[k];
		for(int i=0;i<k;i++) {
			ans[i]=alist.get(i)[0];
		}
		return ans;
	}
}
