package dynamicProgramming;

public class P338 {
	public static void main(String[] args) {
		int num=5;
		int[] arr=countBits(num);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	//最简单的方法，动态规划
	public static int[] countBits(int num) {
		int[] labels=new int[num+1];
		labels[0]=0;
		for(int i=1;i<=num;i++) {
			if(i%2==1)
				labels[i]=labels[i-1]+1;
			else
				labels[i]=labels[i/2];
		}
		return labels;
	}
	//常规的方法
//	public static int[] countBits(int num) {
//		int[] labels=new int[num+1];
//		for(int i=0;i<=num;i++) {
//			String s=Integer.toBinaryString(i);
//			int sum=0;
//			for(int j=0;j<s.length();j++) {
//				if(s.charAt(j)=='1')
//					sum++;
//			}
//			labels[i]=sum;
//		}
//		return labels;
//    }
}
