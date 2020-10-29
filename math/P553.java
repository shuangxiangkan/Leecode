package math;

public class P553 {
	public static void main(String[] args) {
		int[] nums= {1000,100,10,2};
		P553 p=new P553();
		System.out.println(p.optimalDivision(nums));
	}
	public String optimalDivision(int[] nums) {
		StringBuilder sb=new StringBuilder();
		if(nums.length==1)
			return sb.append(nums[0]).toString();
		else if(nums.length==2) {
			sb.append(nums[0]);
			sb.append("/");
			sb.append(nums[1]);
			return sb.toString();
		}else {
			sb.append(nums[0]);
			sb.append("/(");
			for(int i=1;i<nums.length-1;i++) {
				sb.append(nums[i]);
				sb.append("/");
			}
			sb.append(nums[nums.length-1]);
			sb.append(")");
			return sb.toString();
		}
		
    }
}
