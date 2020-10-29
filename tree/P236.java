package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P236 {
	public TreeNode ans;
	public static void main(String[] args) {
		P236 t=new P236();
		TreeNode node3=new TreeNode(3);
		TreeNode node5=new TreeNode(5);
		TreeNode node1=new TreeNode(1);
		TreeNode node6=new TreeNode(6);
		TreeNode node2=new TreeNode(2);
		TreeNode node0=new TreeNode(0);
		TreeNode node8=new TreeNode(8);
		TreeNode node7=new TreeNode(7);
		TreeNode node4=new TreeNode(4);
		node3.left=node5;
		node3.right=node1;
		node5.left=node6;
		node5.right=node2;
		node1.left=node0;
		node1.right=node8;
		node2.left=node7;
		node2.right=node4;
		TreeNode ans=t.lowestCommonAncestor(node3, node5, node1);
		System.out.println(ans.val);
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        map.put(root,null);
        dfs(root,map);
        ArrayList<TreeNode> listP=new ArrayList<>();
        ArrayList<TreeNode> listQ=new ArrayList<>();
        while(p!=null){
            listP.add(p);
            p=map.get(p);
        }
        while(q!=null){
            listQ.add(q);
            q=map.get(q);
        }
        int i=0;
        for(;i<listP.size();i++){
            if(listQ.contains(listP.get(i)))
                break;
        }
        return listP.get(i);
    }
    public void dfs(TreeNode root,Map<TreeNode,TreeNode> map){
        if(root!=null){
            if(root.left!=null) {
            	map.put(root.left,root);
            	dfs(root.left,map);
            }
            if(root.right!=null) {
            	map.put(root.right,root);
            	dfs(root.right,map);
            }
                
        }
    }
	
    
}
