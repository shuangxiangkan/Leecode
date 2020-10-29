package array;

import java.util.Arrays;

public class P16dot06 {
	public static void main(String[] args) {
		int[] a= {-2147483648,1};
				
		int[] b= {2147483647,0};
		System.out.println(smallestDifference(a, b));
	}
	public static int smallestDifference(int[] a, int[] b) {
		int min=Integer.MAX_VALUE;
		Arrays.sort(a);
		Arrays.sort(b);
		int i=0;
		int j=0;
		while(i<a.length&&j<b.length) {
			if(a[i]>=b[j]) {
				if(((long)a[i]-(long)b[j])<min) {
					min=a[i]-b[j];
				}
				j++;
			}
			else {
				if(((long)b[j]-(long)a[i])<min) {
					min=b[j]-a[i];
				}
				i++;
			}
		}
		return min;
    }
}
