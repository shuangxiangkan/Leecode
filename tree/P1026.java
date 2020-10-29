package tree;

import java.sql.Array;
import java.util.ArrayList;

public class P1026 {
	public static void main(String[] args) {
		P1026 p=new P1026();
//		TreeNode root=new TreeNode(8);
//		root.left=new TreeNode(3);
//		root.right=new TreeNode(10);
//		root.left.left=new TreeNode(1);
//		root.left.right=new TreeNode(6);
//		root.left.right.left=new TreeNode(4);
//		root.left.right.right=new TreeNode(7);
//		root.right.right=new TreeNode(14);
//		root.right.right.left=new TreeNode(13);
		
		TreeNode root=new TreeNode(0);
		root.right=new TreeNode(1);
		System.out.println(p.maxAncestorDiff(root));
	}
	public int maxDifference(TreeNode root, ArrayList<Integer> list) {
		if(root==null)
			return 0;
		int max=0;
		for (Integer i : list) {
			if(max<Math.abs(root.val-i))
				max=Math.abs(root.val-i);
		}
		int a=0;
		int b=0;
		if(root.left!=null) {
			ArrayList<Integer> alist=new ArrayList<>(list);
			alist.add(root.val);
			a=maxDifference(root.left, alist);
		}
		if(root.right!=null) {
			ArrayList<Integer> alist=new ArrayList<>(list);
			alist.add(root.val);
			b=maxDifference(root.right, alist);
		}
		int max2=Math.max(a, b);
		return Math.max(max2, max);
	}
	public int maxAncestorDiff(TreeNode root) {
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return 0;
		int max=0;
		ArrayList<Integer> list=new ArrayList<>();
		list.add(root.val);
		return Math.max(maxDifference(root.left,list), maxDifference(root.right,list));
    }
}
