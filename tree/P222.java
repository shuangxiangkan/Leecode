package tree;

public class P222 {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		P222 p=new P222();
		System.out.println(p.countNodes(root));
	}
	public int countNodes(TreeNode root) {
		if(root==null)
			return 0;
		return 1+countNodes(root.left)+countNodes(root.right);
    }
}
