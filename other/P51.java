package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P51 {
	static List<List<String>> lists;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		P51 p=new P51();
		List<List<String>> ans=p.solveNQueens(n);
		for(List<String> item:ans)
			System.out.println(item.toString());
	}
	public  List<List<String>> solveNQueens(int n) {
		lists=new ArrayList<List<String>>();
		if(n==1) {
			List<String> list=new ArrayList<>();
			list.add("Q");
			lists.add(list);
			return lists;
		}
		int[][] queens=new int[n][n];
		int[] labels=new int[n];
 		for(int i=0;i<n;i++) {
 			labels[i]=1;
 			queens[0][i]=1;
			tianchong(i,1,n,queens,labels);
			labels[i]=0;
			queens[0][i]=0;
		}
		
		return lists;
    }
	//k表示到达第k行
	//m表示第k行的第m个元素被标记
	//labels表示钱k行的哪几列已经被标记
	public static void tianchong(int m,int k,int n,int[][] queens,int[] labels) {
		if(k==n-1) {
			int p=-1;
			for(int i=0;i<n;i++) {
				if(labels[i]==0) {
					p=i;
					break;
				}
			}
			if(judge(k,p,n,queens)) {
				queens[k][p]=1;
				ArrayList<String> list=new ArrayList<String>();
				
				for(int i=0;i<n;i++) {
					StringBuilder sb=new StringBuilder();
					for(int j=0;j<n;j++) {
						if(queens[i][j]==0)
							sb.append(".");
						else
							sb.append("Q");
					}
					list.add(sb.toString());
				}
				
				lists.add(list);
			}
			labels[p]=0;
			queens[k][p]=0;
		}else {
			for(int i=0;i<n;i++) {
				if(labels[i]==0&&judge(k,i,n,queens)) {
					labels[i]=1;
					queens[k][i]=1;
					tianchong(i,k+1,n,queens,labels);
					labels[i]=0;
					queens[k][i]=0;
				}
			}
		}
	}
	//第m行
	//第n列
	public static boolean judge(int m,int n,int k,int[][] queues) {
		int j=n;
		for(int i=m-1;i>=0;i--) {
			if((--j)>=0)
				if(queues[i][j]!=0)
					return false;
		}
		j=n;
		for(int i=m-1;i>=0;i--) {
			if((++j)<k)
				if(queues[i][j]!=0)
					return false;
		}
		return true;
	}
}
