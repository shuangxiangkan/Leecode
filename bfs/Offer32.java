package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.soap.Node;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Offer32 {
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
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		if(root==null)
			return ans;
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		Queue<TreeNode> p=new LinkedList<TreeNode>();
		q.add(root);
		List<Integer> l=new ArrayList<>();
		l.add(root.val);
		ans.add(l);
		while(!q.isEmpty()) {
			TreeNode temp=q.poll();
			if(temp.left!=null)
				p.add(temp.left);
			if(temp.right!=null)
				p.add(temp.right);
			if(q.isEmpty()&&!p.isEmpty()) {
				List<Integer> list=new ArrayList<>();
				while(!p.isEmpty()) {
					TreeNode t=p.poll();
					list.add(t.val);
					q.add(t);
				}
				ans.add(list);
				p.clear();
			}
		}
		
		return ans;
    }
}
