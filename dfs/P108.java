package dfs;


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class P108 {
	public static void main(String[] args) {
		int[] nums= {-10,-3,0,5,9};
		P108 p=new P108();
		TreeNode root=p.sortedArrayToBST(nums);
		p.print(root);
	}
	public void print(TreeNode root) {
		if(root!=null) {
			System.out.println(root.val);
			print(root.left);
			print(root.right);
		}
			
	}
	public TreeNode construct(int[] nums, int start,int end) {
		if(start>end)
			return null;
		if(start==end)
			return new TreeNode(nums[start]);
		int mid=(start+end)/2;
		TreeNode root=new TreeNode(nums[mid]);
		root.left=construct(nums, start, mid-1);
		root.right=construct(nums, mid+1, end);
		return root;
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		return construct(nums, 0, nums.length-1);
    }
}
