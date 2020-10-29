package tree;


//class TreeNode {
//      int val;
//      TreeNode left=null;
//      TreeNode right=null;
//      TreeNode(int x) {
//    	  val = x; 
//    }
//}
public class P04dot04 {
	public static void main(String[] args) {
		P04dot04 p=new P04dot04();
		TreeNode root=new TreeNode(3);
//		root.left=new TreeNode(9);
//		root.right=new TreeNode(20);
//		root.left.left=null;
//		root.left.right=null;
//		root.right.left=new TreeNode(15);
//		root.right.right=new TreeNode(7);
//		root.right.left.left=null;
//		root.right.left.right=null;
//		root.right.right.left=null;
//		root.right.right.right=null;
		
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(3);
		root.left.left.left=new TreeNode(4);
		root.left.left.right=new TreeNode(4);
		System.out.println(p.isBalanced(root));
		
	}
	public int getDepth(TreeNode t) {
		if(t==null)
			return 0;
		return Math.max(getDepth(t.left), getDepth(t.right))+1;
	}
	public boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		if(Math.abs(getDepth(root.left)-getDepth(root.right))>1)
			return false;
		return isBalanced(root.left)&&isBalanced(root.right);
    }
}	
