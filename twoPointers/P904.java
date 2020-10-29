package twoPointers;

import java.util.ArrayList;

public class P904 {
	public static void main(String[] args) {
		int[] tree= {0,1,2,2};
		P904 p=new P904();
		System.out.println(p.totalFruit(tree));
	}
	public int totalFruit(int[] tree) {
		int max=0;
		for(int i=0;i<tree.length;i++) {
			ArrayList<Integer> alist=new ArrayList<>();
			alist.add(tree[i]);
			int count=1;
			for(int j=i+1;j<tree.length;j++) {
				if(!alist.contains(tree[j])&&alist.size()<2) {
					alist.add(tree[j]);
					count++;
				}else if(!alist.contains(tree[j])&&alist.size()==2) {
					break;
				}else {
					count++;
				}
			}
			if(max<count)
				max=count;
			if(max==tree.length)
				return max;
		}
		return max;
	}
}
