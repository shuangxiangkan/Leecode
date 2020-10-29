package dynamicProgramming;

import java.util.Arrays;

public class P673 {
	public static void main(String[] args) {
		int[] nums= {2,2,2,2,2};
//		int[] nums= {1,3,5,4,7};
		System.out.println(findNumberOfLIS(nums));
	}
	public static int findNumberOfLIS(int[] nums) {
		if(nums.length==0)
			return 0;
		int[] length=new int[nums.length];
		int[] counts=new int[nums.length];
		Arrays.fill(counts, 1);
		Arrays.fill(length, 1);
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<i;j++) {
				if(nums[j]<nums[i]) {
					if(length[i]<=length[j]) {
						length[i]=length[j]+1;
						counts[i]=counts[j];
					}else if(length[i]-1==length[j]) {
						counts[i]+=counts[j];
					}
				}
			}
		}
		int max=length[0];
		for(int i=1;i<length.length;i++)
			if(max<length[i])
				max=length[i];
		int sum=0;
		for(int i=0;i<counts.length;i++)
			if(length[i]==max)
				sum+=counts[i];
		return sum;
	}
	
	
//	public static int findNumberOfLIS(int[] nums) {
//		if(nums.length==0)
//			return 0;
//		int[] labels=new int[nums.length];
//		int[] counts=new int[nums.length];
//		Arrays.fill(counts, 1);
//		for(int i=0;i<nums.length;i++) {
//			for(int j=0;j<i;j++) {
//				if(nums[j]<nums[i]) {
//					if(labels[j]>labels[i]) {
//						labels[i]=labels[j]+1;
//						counts[i]=counts[j];
//					}
//					else
//					{
//						if(labels[j]+1==labels[i]) {
//							counts[i]+=counts[j];
//						}
//					}
//				}
//			}
//		}
//	}
	
//	public static int findNumberOfLIS(int[] nums) {
//		if(nums.length==0)
//			return 0;
//		int[] labels=new int[nums.length];
//		labels[0]=1;
//		int max=1;
//		int index=-1;
//		for(int i=1;i<nums.length;i++) {
//			if(nums[i]==nums[i-1])
//				labels[i]=labels[i-1];
//			if(nums[i]>nums[i-1]) {
//				labels[i]=labels[i-1]+1;
//				if(max<labels[i]) {
//					max=labels[i];
//					index=i;
//				}
//			}else {
//				for(int j=i-1;j>=0;j--) {
//					if(nums[i]==nums[j]) {
//						labels[i]=labels[j];
//						break;
//					}
//					if(nums[i]>nums[j]) {
//						labels[i]=labels[j]+1;
//						if(max<labels[i]) {
//							max=labels[i];
//							index=i;
//						}
//						break;
//					}
//					if(j==0)
//						labels[i]=1;
//				}
//				
//			}
//		}
//		int sum=0;
//		int cmax=max-1;
//		for(int i=0;i<labels.length;i++)
//			if(cmax==labels[i]&&nums[i]<nums[index])
//				sum++;
//		return sum;
//	}
}
