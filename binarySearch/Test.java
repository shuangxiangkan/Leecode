package binarySearch;

import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		int[][] mat = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
		int threshold = 4;
		Test t=new Test();
//		System.out.println(t.maxSideLength(mat, threshold));
	}
	public int kthSmallest(TreeNode root, int k) {
		LinkedList<TreeNode> stack=new LinkedList<>();
		while(true) {
			while(root!=null) {
				stack.add(root);
				root=root.left;
			}
			root=stack.removeLast();
			if(--k==0)
				return root.val;
			root=root.right;
		}
	}
}
