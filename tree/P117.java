package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class P117 {
	public static void main(String[] args) {
		P117 p=new P117();
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
        Map<Integer, ArrayList<Node>> map=new HashMap<Integer, ArrayList<Node>>();
        Queue<Node> s=new LinkedList<Node>();
        Queue<Node> t=new LinkedList<Node>();
        ArrayList<Node> a=new ArrayList<>();
        a.add(root);
        map.put(1, a);
        t.add(root);
        int i=1;
        while(!t.isEmpty()) {
        	ArrayList<Node> list=new ArrayList<>();
        	if(i!=1)
        		t.clear();
        	while(!s.isEmpty()) {
            	Node n=s.poll();
            	if(n.left!=null) {
            		list.add(n.left);
            		t.add(n.left);
            	}
            	if(n.right!=null) {
            		list.add(n.right);
            		t.add(n.right);	
            	}
            }
        	if(i!=1&&list.size()!=0)
        		map.put(i, list);
        	i++;
        	
        	s=new LinkedList<Node>(t);
        }
        for(int key:map.keySet()) {
        	ArrayList<Node> alist=map.get(key);
        	for(int j=0;j<alist.size()-1;j++) {
        		alist.get(j).next=alist.get(j+1);
        	}
        	alist.get(alist.size()-1).next=null;
        }
        
        return root;
    }
}
