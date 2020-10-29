package math;

public class P1362 {
	public static void main(String[] args) {
		int num=855077252;
		P1362 p=new P1362();
		int[] nums=p.closestDivisors(num);
		for (int i : nums) {
			System.out.println(i);
		}
	}
	public int[] closestDivisors(int num) {
		int num1=num+1;
		int num2=num+2;
		int[] nums=new int[2];
		int c1=0;
		int c2=0;
//		System.out.println((int)Math.sqrt(num1));
		for(int i=(int)Math.sqrt(num1);i>=1;i--) {
			if(num1%i==0) {
				c1=i;
				c2=num1/c1;
				break;
			}
		}
		int s1=0;
		int s2=0;
//		System.out.println((int)Math.sqrt(num2));
		for(int i=(int)Math.sqrt(num2);i>=1;i--) {
			if(num2%i==0) {
				s1=i;
				s2=num2/s1;
				break;
			}
		}
		if(Math.abs(c1-c2)<=Math.abs(s1-s2)) {
			nums[0]=c1;
			nums[1]=c2;
		}else {
			nums[0]=s1;
			nums[1]=s2;
		}
		return nums;
    }
}
