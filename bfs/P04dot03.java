package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class P04dot03 {
	public static void main(String[] args) {
		TreeNode tree=new TreeNode(1);
		tree.left=new TreeNode(2);
		tree.right=new TreeNode(3);
		tree.left.left=new TreeNode(4);
		tree.left.right=new TreeNode(5);
		tree.right.right=new TreeNode(7);
		tree.left.left.left=new TreeNode(8);
		
		P04dot03 p=new P04dot03();
		ListNode[] ln=p.listOfDepth(tree);
		for (ListNode node : ln) {
			while(node!=null) {
				System.out.print(node.val+",");
				node=node.next;
			}
			System.out.println();
		}
	}
	public ListNode[] listOfDepth(TreeNode tree) {
		ArrayList<ListNode> alist=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		if(tree!=null)
			queue.add(tree);
		while(!queue.isEmpty()) {
			ListNode start=null;
			ListNode temp=null;
			for(int i=queue.size();i>0;i--) {
				TreeNode t=queue.poll();
				if(start==null) {
					start=new ListNode(t.val);
					temp=start;
				}else {
					start.next=new ListNode(t.val);
					start=start.next;
				}
				if(t.left!=null)
					queue.add(t.left);
				if(t.right!=null)
					queue.add(t.right);
			}
			alist.add(temp);
		}
		ListNode[] ans=new ListNode[alist.size()];
		for(int i=0;i<alist.size();i++)
			ans[i]=alist.get(i);
		return ans;
    }
}
