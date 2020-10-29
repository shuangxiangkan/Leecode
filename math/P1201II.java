package math;

import java.util.Arrays;

public class P1201II {
	public static void main(String[] args) {
//		int n=1000000000;
////		int n=910000000;
//		int a=2;
//		int b=217983653;
//		int c=336916467;
//		int n=16;
//		int a=2;
//		int b=3;
//		int c=4;
		int n=1000000000;
		int a=2;
		int b=168079517;
		int c=403313907;
		P1201II p=new P1201II();
		System.out.println(p.nthUglyNumber(n, a, b, c));
	}
	public int nthUglyNumber(int n, int a, int b, int c) {
		int[] array= {a,b,c};
		Arrays.sort(array);
		long d=array[0];
		long e=array[1];
		long f=array[2];
		int count=1;
		int i=2;
		while(d*i<e)
			i++;
		int j=1;
		int k=1;
		long temp=d;
		while(count<n) {
			long aa=d*i;
			long bb=e*j;
			long cc=f*k;
			if(aa<=bb&&aa<=cc) {
				if(aa!=temp) {
					count++;
					temp=aa;
				}
				i++;
			}
			else if(bb<=aa&&bb<=cc) {
				if(bb!=temp) {
					count++;
					temp=bb;
//					System.out.println("bb:"+bb);
				}
				j++;
			}else if(cc<=aa&&cc<=bb) {
				if(cc!=temp) {
					count++;
					temp=cc;
//					System.out.println("cc:"+cc);
				}
				k++;
			}
		}
		return (int)temp;
	}
}
