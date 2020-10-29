package dfs;

import java.util.LinkedList;
import java.util.Queue;

//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }
public class P114 {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(6);
		
		P114 p=new P114();
		p.flatten(root);
		while(root!=null) {
			System.out.println(root.val);
			root=root.right;
		}
	}
	Queue<TreeNode> queue;
	public void DFS(TreeNode root) {
		if(root==null)
			return;
		queue.add(root);
		DFS(root.left);
		DFS(root.right);
	}
	public void flatten(TreeNode root) {
		if(root==null)
			return;
		queue=new LinkedList<TreeNode>();
        DFS(root);
        queue.poll();
        TreeNode r=root;
        r.left=null;
        while(!queue.isEmpty()) {
        	TreeNode temp=queue.poll();
        	r.right=temp;
        	temp.left=null;
        	r=temp;
        }
    }
}
