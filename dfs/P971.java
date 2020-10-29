package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P971 {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		int[] voyage= {2,1};
		
		P971 p=new P971();
		List<Integer> list=p.flipMatchVoyage(root, voyage);
		for (int i : list) {
			System.out.println(i);
		}
	}
	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		List<Integer> list=new ArrayList<>();
		
		int index=0;
		Stack<TreeNode> stack=new Stack<>();
		TreeNode p=root;
		while(p!=null||!stack.isEmpty()) {
			if(p!=null) {
				//当前遍历：处理当前节点
				//当前节点不等于voyage[index]的值，则不能反转，返回-1
				//否则index指向voyage的下一个值，等待下一次的比较
				if(p.val!=voyage[index]) {
					list.clear();
					list.add(-1);
					break;
				}else {
					index++;
				}
				stack.push(p);
				
				//因为每一个节点的值都不同
				//只有当左右子节点都不为空，且右子树节点等于voyage[index]时，交换当前节点的左右子节点。
				//左子节点不用判断值是否相等，因为会在下一次遍历判断(if(p.val!=voyage[index])).
				//左子节点为空时，下一次遍历即访问了右子节点，因此也不用在这里判断.
				if(p.left!=null&&p.right!=null&&p.right.val==voyage[index]) {
					list.add(p.val);
					TreeNode swap=p.right;
					p.right=p.left;
					p.left=swap;
				}
				//前序遍历：指向左子节点
				p=p.left;
				
			}
			else {
				p=stack.pop().right;
			}
		}
		return list;
    }
}
