package stack;

public class P456 {
	public static void main(String[] args) {
		int[] nums= {-1, 3, 2, 0};
		P456 p=new P456();
		System.out.println(p.find132pattern(nums));
	}
	public boolean find132pattern(int[] nums) {
		int max=nums[0];
		for(int i=0;i<nums.length;i++) {
			
		}
		
		
		int len=nums.length;
		for(int i=0;i<=len-3;i++) {
			for(int j=i+1;j<=len-2;j++) {
				for(int k=j+1;k<=len-1;k++) {
					if(nums[i]<nums[k]&&nums[k]<nums[j])
						return true;
				}
			}
		}
		return false;
    }
}
