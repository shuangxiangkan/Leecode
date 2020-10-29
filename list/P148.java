package list;

import java.util.*;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { 
    	 val = x; }
}

public class P148 {
	public static void main(String[] args) {
		P148 p=new P148();
		ListNode node1=new ListNode(4);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(1);
		ListNode node4=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		ListNode ans=p.sortList(node1);
		while(ans!=null) {
			System.out.print(ans.val+" ");
			ans=ans.next;
		}
	}
	public ListNode sortList(ListNode head) {
        ListNode head0=new ListNode(Integer.MIN_VALUE);
        head0.next=head;
        ListNode h=new ListNode(Integer.MIN_VALUE);
        ListNode p=head0;
        ListNode q=h;
        while(p.next!=null){
            ListNode temp=p.next;
            p.next=p.next.next;
            if(q.next==null) {
            	temp.next=q.next;
            	q.next=temp;
            }
                
            else{
                while(q.next!=null&&q.next.val<temp.val){
                    q=q.next;
                }
                if(q.next==null){
                	temp.next=q.next;
                	q.next=temp;
                }
                else{
                    temp.next=q.next;
                    q.next=temp;
                }
                q=h;
            }
        }
        return h.next;
    }
	
	
//	public ListNode sortList(ListNode head) {
//        // ListNode head=new ListNode(Integer.MIN_VALUE);
//        ArrayList<Integer> alist=new ArrayList<>();
//        ListNode p=head;
//        while(p!=null){
//            alist.add(p.val);
//            p=p.next;
//        }
//        Collections.sort(alist);
//        ListNode h=new ListNode(Integer.MIN_VALUE);
//        ListNode q=h;
//        for(int i=0;i<alist.size();i++){
//            ListNode temp=new ListNode(alist.get(i));
//            q.next=temp;
//            q=temp;
//        }
//        return h.next;
//    }
	
}
