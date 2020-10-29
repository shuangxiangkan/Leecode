package dynamicProgramming;

import java.util.HashMap;

public class P523 {
	public static void main(String[] args) {
		int[] nums= {23,2,6,4,7};
		int k=6;
		System.out.println(checkSubarraySum(nums, k));
	}
	//哈希表法
	public static boolean checkSubarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> hash=new HashMap<>();
		hash.put(0, -1);
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if(k!=0) {
				sum=sum%k;
			}
			if(hash.containsKey(sum)) {
				if(i-hash.get(sum)>1)
					return true;
			}else {
				hash.put(sum, i);
			}
		}
		return false;
	}
	
	
//	//暴力解
//	public static boolean checkSubarraySum(int[] nums, int k) {
//		if(nums==null||nums.length==0)
//			return false;
//		if(nums.length==2) {
//			int sum=nums[0]+nums[1];
//			if(sum == k || (k != 0 && sum % k == 0)) {
//				return true;
//			}else
//				return false;
//		}
//		int sum=0;
//		for(int i=2;i<=nums.length;i++) {
//			for(int j=0;j<nums.length-i+1;j++) {
//				sum=0;
//				for(int m=j;m<j+i;m++) {
//					sum+=nums[m];
//				}
//				if(sum == k || (k != 0 && sum % k == 0)) {
//					return true;
//				}
//			}
//		}
//		return false;
//    }
}
