package tree;

import java.util.ArrayList;
import java.util.List;

public class P894 {
	public static void main(String[] args) {
		int N=7;
		P894 p=new P894();
		List<TreeNode> list=p.allPossibleFBT(N);
		System.out.println(list.size());
	}
	public List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> list=new ArrayList<TreeNode>();
		if(N%2==0)
			return new ArrayList<>();
		else if(N==1) {
			list.add(new TreeNode(0));
			return list;
		}
		for(int i=1;i<N;i=i+2) {
			List<TreeNode> list1=allPossibleFBT(i);
			List<TreeNode> list2=allPossibleFBT(N-i-1);
			for (TreeNode t1 : list1) {
				for (TreeNode t2 : list2) {
					TreeNode t=new TreeNode(0);
					t.left=t1;
					t.right=t2;
					list.add(t);
				}
			}
		}
		return list;
    }
}
