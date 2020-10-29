package math;

import java.util.Arrays;

public class P976 {
	public static void main(String[] args) {
//		int[] A= {2,1,2};
		int[] A= {3,2,3,4};
		P976 p=new P976();
		System.out.println(p.largestPerimeter(A));
	}
	public int largestPerimeter(int[] A) {
		int perimeter=0;
		Arrays.sort(A);
		for(int i=A.length-1;i>=2;i--) {
			if((A[i]+A[i-1]>A[i-2])&&(A[i]+A[i-2]>A[i-1])&&(A[i-1]+A[i-2]>A[i])) {
				perimeter=A[i]+A[i-1]+A[i-2];
				break;
			}
		}
		
		return perimeter;
    }
}
