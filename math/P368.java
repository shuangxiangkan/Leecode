package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P368 {
	public static void main(String[] args) {
//		int[] nums= {1,2,3};
		int[] nums= {1,2,4,8};
		P368 p=new P368();
		List<Integer> results=p.largestDivisibleSubset(nums);
		for (int r : results) {
			System.out.println(r);
		}
	}
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums.length==0)
			return new ArrayList<>();
		Arrays.sort(nums);
		Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
		list.add(nums[0]);
		map.put(nums[0], list);
		for(int i=1;i<nums.length;i++) {
			int max=0;
			int temp=nums[i];
			for(int j=0;j<i;j++) {
				if(nums[i]%nums[j]==0) {
					if(max<map.get(nums[j]).size()) {
						max=map.get(nums[j]).size();
						temp=nums[j];
					}
				}
			}
			if(temp==nums[i]) {
				List<Integer> alist=new ArrayList<Integer>();
				alist.add(nums[i]);
				map.put(nums[i], alist);
			}else {
				List<Integer> alist=new ArrayList<Integer>(map.get(temp));
				alist.add(nums[i]);
				map.put(nums[i], alist);
			}
		}
		int m=map.get(nums[0]).size();
		int temp=nums[0];
		for(int i=1;i<nums.length;i++) {
			if(m<map.get(nums[i]).size()) {
				m=map.get(nums[i]).size();
				temp=nums[i];
			}
		}
		return map.get(temp);
    }
}
