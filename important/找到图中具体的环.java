package important;

import java.util.*;

public class 找到图中具体的环 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j]=sc.nextInt();
			}
		}
		int start=sc.nextInt();
		ArrayList<Integer> alist=new ArrayList<>();
		for(int i=0;i<n;i++){
			if(a[start][i]==1)
				circles(n,a,i,start,alist);
		}
		
	}
	public static void circles(int n,int[][] a, int k, int start, ArrayList<Integer> alist){
		if(k==start){
			System.out.print(start);
			for(int item:alist)
				System.out.print(item);
			System.out.println();
		}else if(alist.contains(k)){
			return;
		}else{
			alist.add(k);
			for(int i=0;i<n;i++){
				if(a[k][i]==1){
					circles(n,a,i,start,alist);
				}
			}
			alist.remove(alist.size()-1);
		}
	}
}
