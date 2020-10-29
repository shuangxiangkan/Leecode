package math;

public class test2 {
	public static void main(String[] args) {
		int a=2;
		int b=8;
		test2 t=new test2();
		System.out.println(t.leastCommonMultiple(a, b));
	}
	public int leastCommonMultiple(int a,int b) {
		int product=a*b;
		int temp=b;
		while(b!=0) {
			temp=b;
			b=a%b;
			a=temp;
		}
		return product/a;
	}
}
