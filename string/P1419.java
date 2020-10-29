package string;

public class P1419 {
	public static void main(String[] args) {
//		String croakOfFrogs="croakcroak";
		String croakOfFrogs="crcoakroak";
//		String croakOfFrogs = "croakcrook";
//		String croakOfFrogs = "croakcroa";
//		String croakOfFrogs="croakcrcoakroakcroak";
//		String croakOfFrogs="crocakcroraoakk";
		P1419 p=new P1419();
		System.out.println(p.minNumberOfFrogs(croakOfFrogs));
	}

	public int minNumberOfFrogs(String croakOfFrogs) {
		int num=0;
		char[] croaks=croakOfFrogs.toCharArray();
		char[] cro= {'c','r','o','a','k'};
		int[] nums=new int[5];
		boolean flag=true;
		for(int i=0;i<croaks.length;i++) {
			if(croaks[i]=='c') {
				nums[0]++;		
				if(nums[0]-nums[4]>num)
					num=nums[0]-nums[4];
				
			}
			else if(croaks[i]=='r') {
				if(nums[0]>nums[1]) {
					nums[1]++;
				}else {
					flag=false;
					break;
				}
			}
			else if(croaks[i]=='o') {
				if(nums[1]>nums[2]) {
					nums[2]++;
				}else {
					flag=false;
					break;
				}
			}
			else if(croaks[i]=='a') {
				if(nums[2]>nums[3]) {
					nums[3]++;
				}else {
					flag=false;
					break;
				}
			}
			else if(croaks[i]=='k') {
				if(nums[3]>nums[4]) {
					nums[4]++;
				}else {
					flag=false;
					break;
				}
			}
		}
		if(flag&&(nums[0]+nums[1]+nums[2]+nums[3]+nums[4]==croakOfFrogs.length())&&(nums[0]==nums[1])&&(nums[1]==nums[2])&&(nums[2]==nums[3])&&(nums[3]==nums[4])&&nums[0]+nums[1]+nums[2]+nums[3]+nums[4]==croakOfFrogs.length()) {
			return num;
		}
		else
			return -1;
    }
}
