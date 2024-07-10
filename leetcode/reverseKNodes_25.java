public class reverseKNodes_25 {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
        
       class Solution {
           private static ListNode findKNode(ListNode head,int k){
               ListNode temp=head;
               int count=0;
               while(temp!=null){
                   count++;
                   if(count==k){
                       return temp;
                   }
                   temp=temp.next;
               }
               return null;
           }
           private static ListNode reverse(ListNode head){
               ListNode temp=head;
               ListNode prev=null;
               while(temp!=null){
                   ListNode nextNode =temp.next;
                   temp.next=prev;
                   prev=temp;
                   temp=nextNode;
               }
               return prev;
           }
           public ListNode reverseKGroup(ListNode head, int k) {
               ListNode temp=head;
               ListNode prevNode=null;
               while(temp!=null){
                   ListNode nodeK=findKNode(temp,k);
                   if(nodeK==null){
                       if(prevNode!=null){
                           prevNode.next=temp;
                           break;
                       }
                   }
                   ListNode nextNode=nodeK.next;
                   nodeK.next=null;
                   reverse(temp);
                   if(temp==head){
                       head=nodeK;
                   }else{
                       prevNode.next=nodeK;
                   }
                   prevNode=temp;
                   temp=nextNode;
               }
               return head;
           }
       }
}
