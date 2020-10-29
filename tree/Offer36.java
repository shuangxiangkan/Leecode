package tree;

//Definition for a Node.
class Node {
 public int val;
 public Node left;
 public Node right;

 public Node() {}

 public Node(int _val) {
     val = _val;
 }

 public Node(int _val,Node _left,Node _right) {
     val = _val;
     left = _left;
     right = _right;
 }
};

public class Offer36 {
	public static void main(String[] args) {
		Node n4=new Node(4);
		Node n2=new Node(2);
		Node n5=new Node(5);
		Node n1=new Node(1);
		Node n3=new Node(3);
		n4.left=n2;
		n4.right=n5;
		n2.left=n1;
		n2.right=n3;
		
	}
	 public Node treeToDoublyList(Node root) {
	     Node head=new Node();
	     Node start=sortTree(root);
	     Node end=start;
	     while(start.left!=null)
	         start=start.left;
	     while(end.right!=null)
	         end=end.right;
	     head.right=start;
	     start.left=end;
	     end.right=start;
	     return head;
	 }
	 public Node sortTree(Node root){
	        if(root!=null){
	            if(root.left!=null){
	                Node front=root.left;
	                while(front.right!=null){
	                    front=front.right;
	                }
	                treeToDoublyList(root.left);
	                root.left=front;
	                front.right=root;
	                
	            }
	            if(root.right!=null){
	                Node back=root.right;
	                while(back.left!=null){
	                    back=back.left;
	                }
	                treeToDoublyList(root.right);
	                root.right=back;
	                back.left=root;
	                
	            }
	        }
	        return root;
	    }
}
