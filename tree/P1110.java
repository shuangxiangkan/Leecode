package tree;

import java.util.ArrayList;
import java.util.List;

public class P1110 {
	public static void main(String[] args) {
		P1110 p=new P1110();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		int[] to_delete= {3,5};
		List<TreeNode> list=p.delNodes(root, to_delete);
		for (TreeNode node : list) {
			p.print(node);
			System.out.println("-----------------");
		}
		
	}
	public void print(TreeNode root) {
		if(root!=null){
			System.out.println(root.val);
			print(root.left);
			print(root.right);
		}
	}
	List<TreeNode> list;
	List<Integer> deleteNodes;
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		list=new ArrayList<>();
		deleteNodes=new ArrayList<>();
		for(int d:to_delete) {
			deleteNodes.add(d);
		}
		boolean flag=true;
		delete(root,flag);
		return list;
    }
	public void delete(TreeNode root,boolean flag) {
		if(root==null)
			return;
		if(!deleteNodes.contains(root.val)) {
			if(root.left!=null&&deleteNodes.contains(root.left.val)) {
				delete(root.left,true);
				root.left=null;
			}else {
				delete(root.left,false);
			}
			if(root.right!=null&&deleteNodes.contains(root.right.val)) {
				delete(root.right,true);
				root.right=null;
			}else {
				delete(root.right,false);
			}
			if(flag)
				list.add(root);
		}
		else {
			delete(root.left,true);
			delete(root.right,true);
		}
	}
}
