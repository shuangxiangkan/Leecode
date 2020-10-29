package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		
		Node node0=new Node(7);
		Node node1=new Node(13);
		Node node2=new Node(11);
		Node node3=new Node(10);
		Node node4=new Node(1);
		node0.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node1.random=node0;
		node2.random=node4;
		node3.random=node2;
		node4.random=node0;
		
		
//		Node node1=new Node(1);
//		Node node2=new Node(2);
//		node1.next=node2;
//		node1.random=node2;
//		node2.next=null;
//		node2.random=node2;
		
		Node q=node0;
		while(q!=null) {
			System.out.print(q.val+" ");
			q=q.next;
		}
		System.out.println();
		q=node0;
		while(q!=null) {
			if(q.random==null) {
				System.out.print(-1+" ");
			}else {
				System.out.print(q.random.val+" ");
			}
			q=q.next;
		}
		System.out.println();
		
		Node head=s.copyRandomList(node0);
		Node p=head;
		while(p!=null) {
			System.out.print(p.val+" ");
			p=p.next;
		}
		System.out.println();
		p=head;
		while(p!=null) {
			if(p.random==null) {
				System.out.print(-1+" ");
			}else {
				System.out.print(p.random.val+" ");
			}
			p=p.next;
		}
	}
	public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> map=new HashMap<>();
        Node head2=new Node(head.val);
        Node p=head;
        Node q=head2;
        map.put(p, q);
        while(p.next!=null){
            p=p.next;
            Node node=new Node(p.val);
            map.put(p,node);
            q.next=node;
            q=q.next;
        }
        p=head;
        q=head2;
        while(p!=null){
            Node m=p.random;
            Node n=map.get(m);
            q.random=n;
            p=p.next;
            q=q.next;
//            Integer.MIN_VALUE;
//            Integer.MIN_VALUE;
        }
        return head2;
    }
}

