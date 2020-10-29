package tree;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class P951 {
	public static void main(String[] args) {
		TreeNode root1=new TreeNode(1);
		TreeNode root2=new TreeNode(1);
		//root1
		root1.left=new TreeNode(2);
		root1.right=new TreeNode(3);
		root1.left.left=new TreeNode(4);
		root1.left.right=new TreeNode(5);
		root1.right.left=new TreeNode(6);
		root1.left.right.left=new TreeNode(7);
		root1.left.right.right=new TreeNode(8);
		
		//root2
		root2.left=new TreeNode(3);
		root2.right=new TreeNode(2);
		root2.left.right=new TreeNode(6);
		root2.right.left=new TreeNode(4);
		root2.right.right=new TreeNode(5);
		root2.right.right.left=new TreeNode(8);
		root2.right.right.right=new TreeNode(7);
		
		P951 p=new P951();
		System.out.println(p.flipEquiv(root1, root2));
		
	}
	
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if(root1==null&&root2==null)
			return true;
		else if(root1==null)
			return false;
		else if(root2==null)
			return false;
		else if(root1.val!=root2.val)
			return false;
		else {
			return (flipEquiv(root1.left, root2.left)&&flipEquiv(root1.right, root2.right))||
					(flipEquiv(root1.left, root2.right)&&flipEquiv(root1.right, root2.left));
		}
    }
}
