package binarySearch;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P287 {
	public static void main(String[] args) {
		int[] nums= {3,1,3,4,2};
		P287 p=new P287();
		System.out.println(p.findDuplicate(nums));
	}
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		int i=0;
		for(i=0;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1])
				break;
		}
		return nums[i];
    }
	
//	public int findDuplicate(int[] nums) {
//		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
//		for (int n : nums) {
//			if(map.containsKey(n))
//				return n;
//			else
//				map.put(n, 1);
//		}
//		return -1;
//    }
}
