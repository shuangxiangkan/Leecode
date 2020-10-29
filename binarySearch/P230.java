package binarySearch;

import java.util.ArrayList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class P230 {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(1);
		root.right=new TreeNode(4);
		root.left.right=new TreeNode(2);
		int k=1;
		P230 p=new P230();
		System.out.println(p.kthSmallest(root, k));
	}
	ArrayList<Integer> alist;
	public void getNodeVal(TreeNode root) {
		if(root!=null) {
			alist.add(root.val);
			getNodeVal(root.left);
			getNodeVal(root.right);
		}
	}
	public int kthSmallest(TreeNode root, int k) {
        alist=new ArrayList<>();
        getNodeVal(root);
        alist.sort(null);
        return alist.get(k-1);
    }
}
