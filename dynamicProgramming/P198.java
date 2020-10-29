package dynamicProgramming;

public class P198 {
	public static void main(String[] args) {
		int[] nums= {2,7,9,3,1};
		System.out.println(rob(nums));
	}
	public static int rob(int[] nums) {
		if(nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];
		int first=nums[0];
		int second=Math.max(first, nums[1]);
		for(int i=2;i<nums.length;i++) {
			int temp=second;
			second=Math.max(first+nums[i],second);
			first=temp;
		}
		return second;
    }
}
