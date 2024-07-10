
public class rotateList_61 {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
        
       class Solution {
           public ListNode rotateRight(ListNode head, int k) {
               if(head==null ||head.next==null){
                   return head;
               }
               ListNode temp=head;
               int len=1;
               ListNode tail=head;
               while(tail.next!=null){
                   len++;
                   tail=tail.next;
               }
               if(k%len==0){
                   return head;
               }
               k=k%len;
               int count=len-k-1;
               tail.next=head;
               while(count!=0){
                   count--;
                   temp=temp.next;
               }
               head=temp.next;
               temp.next=null;
               return head;
           }
       }
}
