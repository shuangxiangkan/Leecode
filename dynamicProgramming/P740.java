package dynamicProgramming;

import java.util.Arrays;

public class P740 {
	public static void main(String[] args) {
		int[] nums= {2, 2, 3, 3, 3, 4};
		System.out.println(deleteAndEarn(nums));
	}
	public static int deleteAndEarn(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];
		Arrays.sort(nums);
		int max=nums[nums.length-1];
		int[] records=new int[max+1];
		for(int i=0;i<nums.length;i++) {
			records[nums[i]]++;
		}
		int[] dp=new int[max+1];
		dp[0]=0;
		dp[1]=records[1];
		for(int j=2;j<records.length;j++) {
			dp[j]=Math.max(dp[j-1], dp[j-2]+records[j]*j);
		}
		return dp[max];
	}
	
}
