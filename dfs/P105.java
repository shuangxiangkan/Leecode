package dfs;

public class P105 {
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		P105 p=new P105();
		TreeNode root=p.buildTree(preorder, inorder);
		p.print(root);
	}
	public void print(TreeNode root) {
		if(root!=null) {
			System.out.println(root.val);
			print(root.left);
			print(root.right);
		}
	}
	public TreeNode tree(int[] preorder,int preStart,int preEnd, int[] inorder, int inStart,int inEnd) {
		if(preStart>preEnd)
			return null;
		int val=preorder[preStart];
		TreeNode root=new TreeNode(val);
		int index=inStart;
		for(;index<=inEnd;index++) {
			if(inorder[index]==val)
				break;
		}
		root.left=tree(preorder,preStart+1,preStart+(index-inStart),inorder,inStart,index-1);
		root.right=tree(preorder,preStart+(index-inStart)+1,preEnd,inorder,inStart+(index-inStart)+1,inEnd);
		return root;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0)
			return null;
		return tree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
}
