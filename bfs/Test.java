package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		
		Offer32 p=new Offer32();
		List<List<Integer>> ans=p.levelOrder(root);
		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root!=null)
			queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> temp=new ArrayList<>();
			for(int i=queue.size();i>0;i--) {
				TreeNode node=queue.poll();
				temp.add(node.val);
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
				
			}
			res.add(temp);
		}
		return res;
	}
}
