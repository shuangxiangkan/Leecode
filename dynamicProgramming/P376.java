package dynamicProgramming;

public class P376 {
	public static void main(String[] args) {
//		int[] nums= {1,7,4,9,2,5};
//		int[] nums= {0,0,0};
		int[] nums= {3,3,3,2,5,3,3,3,4,3};
		System.out.println(wiggleMaxLength(nums));
	}
	public static int wiggleMaxLength(int[] nums) {
		if(nums.length==0)
			return 0;
		if(nums.length==1)
			return 1;
		int[] labels=new int[nums.length];
		labels[0]=1;
		int i=1;
		for(;i<nums.length;i++) {
			if(nums[i]==nums[i-1]) {
				labels[i]=labels[i-1];
			}
				
			else {
				labels[i]=labels[i-1]+1;
				break;
			}
				
		}
		if(nums.length>i) {
			int flag=nums[i]-nums[i-1];
			for(int j=i+1;j<nums.length;j++) {
				if((nums[j]-nums[j-1])*flag>0) {
					labels[j]=labels[j-1];
					flag=nums[j]-nums[j-1];
				}	
				else if((nums[j]-nums[j-1])*flag<0)
				{
					labels[j]=labels[j-1]+1;
					flag=nums[j]-nums[j-1];
				}
//				else if((nums[j]-nums[j-1])!=0&&(nums[j]-nums[j-1])*(nums[j-1]-nums[j-2])<0) {
//					labels[j]=labels[j-1]+1;
//					flag=nums[j]-nums[j-1];
//				}
				else
				{
					labels[j]=labels[j-1];
				}
			}
			return labels[labels.length-1];
		}else {
			return labels[1];
		}
		
	}
	

}
