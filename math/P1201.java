package math;

import java.util.Arrays;

public class P1201 {
	public static void main(String[] args) {
//		int n=5;
//		int a=2;
//		int b=11;
//		int c=13;
//		int n=12;
//		int a=2;
//		int b=2;
//		int c=2;
//		int n=1000000000;
		int n=1000000000;
//		int n=900000000;
		int a=2;
		int b=217983653;
		int c=336916467;
		P1201 p=new P1201();
		System.out.println(p.nthUglyNumber(n, a, b, c));
	}
	public int nthUglyNumber(int n, int a, int b, int c) {
		int[] array= {a,b,c};
		Arrays.sort(array);
		a=array[0];
		b=array[1];
		c=array[2];
		int count=1;
		boolean flag=true;
		int i=2;
		int j=1;
		int k=1;
		long temp=a;
		while(count<n) {
			count++;
			long aa=a*i;
			long bb=b*j;
			long cc=c*k;
			if(aa<=bb&&aa<=cc) {
				if(count==n)
					return a*i;
				if(temp==aa)
					count--;
				temp=aa;
				i++;
				
			}else if(bb<=aa&&bb<=cc) {
				if(count==n)
					return b*j;
				if(temp==bb)
					count--;
				temp=bb;
				j++;
				
			}else if(cc<=aa&&cc<=bb) {
				if(count==n)
					return c*k;
				if(temp==cc)
					count--;
				temp=cc;
				k++;
				
			}
		}
		return a;
    }
}
