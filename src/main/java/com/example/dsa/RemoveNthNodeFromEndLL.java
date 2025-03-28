package com.example.dsa;

public class RemoveNthNodeFromEndLL {
    public static void main(String[] args) {
        int[] list={2,5,4,3,18,25,23,7};
        ListNode head=new ListNode();
        ListNode temp=head;
        for(int i=0;i<list.length-1;i++){
            temp.val=list[i];
            //System.out.println(temp.val);
            temp.next=new ListNode();
            temp=temp.next;
        }
        temp.val=list[list.length-1];
        temp.next=null;
//        System.out.println("before removing");
//        temp=head;
//        while(temp!=null){
//            System.out.println(temp.val);
//            temp=temp.next;
//        }
        int n=3;
        ListNode result=remove(head,n);
        //System.out.println("after removing " + result.val);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static ListNode remove(ListNode head,int n){
        //We go from first node to nth node with a fast pointer
        //Then from slow pointer we will go till fast pointer is null (basically slow is now at "length-n" position and we wanted this position
        //using a single iteration we can now remove the node next to slow pointer
        ListNode fast=head,slow=head;
        System.out.println(fast.val + " " + slow.val);
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        System.out.println(fast.val + " " + slow.val);
        //If n==length it means we have to remove first element
        if(fast==null) return head.next;
        while(fast.next!=null){

            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
