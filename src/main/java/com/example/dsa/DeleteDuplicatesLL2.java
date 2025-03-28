package com.example.dsa;

public class DeleteDuplicatesLL2 {
    public static void main(String[] args) {
        int[] list={1,1,1,2,3,4,4,5,5,5,6,7};
        ListNode head=new ListNode();
        ListNode temp=head;
        for(int i=0;i<list.length;i++){
            temp.val=list[i];
            //System.out.println(temp.val);
            temp.next=new ListNode();
            temp=temp.next;
        }
        ListNode result=deleteDuplicates2(head);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }


    }
    public static ListNode deleteDuplicates2(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode nextNode=head.next;
        //We check if next node is equal to curr node or not.
        //If both are equal then we loop till we find a different value and solve from there (return when we find head which is different)
        if(head.val==nextNode.val){
            while(nextNode!=null && head.val==nextNode.val){
                nextNode=nextNode.next;
            }
            return deleteDuplicates2(nextNode);
        }
        //If we find unequal value we delete duplicate values ahead head.next (solve for head.next and forward using recursion) and return head.
        else{
            head.next=deleteDuplicates2(nextNode);
            return head;
        }
    }
}
class ListNode {
     int val;
     ListNode next;
//     public String toString(){
//         return Integer.toString(val);
//     }
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

 }
