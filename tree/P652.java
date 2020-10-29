package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class P652 {
	Map<String, Integer> map;
	List<TreeNode> list;
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.left=new TreeNode(2);
		root.right.right=new TreeNode(4);
		root.right.left.left=new TreeNode(4);
		
		P652 p=new P652();
		List<TreeNode> list=p.findDuplicateSubtrees(root);
		for (TreeNode treeNode : list) {
			System.out.println(treeNode.val);
		}
	}
	public String collect(TreeNode root) {
		if(root==null)
			return "#";
		StringBuilder sb=new StringBuilder();
		sb.append(root.val);
		sb.append(",");
		sb.append(collect(root.left));
		sb.append(",");
		sb.append(collect(root.right));
		map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
		if(map.get(sb.toString())==2) {
			list.add(root);
		}
		return sb.toString();
	}
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map=new HashMap<String, Integer>();
        list=new ArrayList<>();
        collect(root);
        
        return list;
    }
}
