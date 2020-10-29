package binarySearch;

public class P162 {
	public static void main(String[] args) {
//		int[] nums = {1,2,3,1};
//		int[] nums= {1,2};
		int[] nums= {1,2,1,3,5,6,4};
		P162 p=new P162();
		System.out.println(p.findPeakElement(nums));
	}
	public int findPeakElement(int[] nums) {
		int start=0;
		int end=nums.length-1;
		
		while(start<end) {
			int mid=(start+end)/2;
			if(nums[mid]>nums[mid+1])
				end=mid;
			else
				start=mid+1;
		}
		return start;
    }
}
