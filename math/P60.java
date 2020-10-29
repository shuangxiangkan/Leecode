package math;

import java.util.ArrayList;

public class P60 {
	public static void main(String[] args) {
		P60 p=new P60();
		int n=4;
		int k=9;
//		int n=3;
//		int k=2;
//		int n=3;
//		int k=4;
		System.out.println(p.getPermutation(n, k));
	}
	public String getPermutation(int n, int k) {
        ArrayList<Integer> alist=new ArrayList<>();
        for(int i=1;i<=n;i++)
            alist.add(i);
        String ans=result(alist,n,k);
        return ans;
    }
    public int factorial(int n){
        int product=1;
        for(int i=2;i<=n;i++)
            product*=i;
        return product;
    }
    public String result(ArrayList<Integer> alist,int n,int k){
        if(n==0)
            return "";
//        if(k==1){
        if(n==1) {
        	return String.valueOf(alist.get(0));
//            StringBuilder strb=new StringBuilder();
//            for(int item:alist)
//                strb.append(item);
//            return strb.toString();
        }
        int f=factorial(n);
        int d=f/n;
        int index=k/d;
        if(k%d==0)
        	index=k/d-1;
        int s=alist.get(index);
        alist.remove(index);
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb.append(result(alist,n-1,k-(d*index)));
        return sb.toString();
    }
}
