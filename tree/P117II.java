package tree;

import java.util.LinkedList;
import java.util.Queue;

public class P117II {
	public static void main(String[] args) {
		P117II p=new P117II();
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.right=new Node(7);
		Node n=p.connect(root);
		p.print(n);
	}
	public void print(Node n) {
		if(n!=null) {
			if(n.next==null)
				System.out.println(n.val+":"+"#");
			else
				System.out.println(n.val+":"+n.next.val);
			print(n.left);
			print(n.right);
		}
	}
	public Node connect(Node root) {
		if(root==null)
			return root;
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			int len=q.size();
			for(int i=0;i<len;i++) {
				Node node=q.poll();
				if(i<len-1)
					node.next=q.peek();
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
		}
		return root;
	}
}
