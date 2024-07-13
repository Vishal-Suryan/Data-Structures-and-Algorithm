public class swapNodePairs {
    public class swapNodePair_24 {
        public class ListNode {
                 int val;
                 ListNode next;
                 ListNode() {}
                 ListNode(int val) { this.val = val; }
                 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
             }
            
           class Solution {
               public ListNode swapPairs(ListNode head) {
                   if(head==null) return null;
                   if(head.next==null) return head;
                   ListNode temp=head;
                   ListNode temp1=head.next;
                   while(temp1.next!=null && temp1.next.next!=null){
                       int val=temp.val;
                       temp.val=temp1.val;
                       temp1.val=val;
                       temp=temp.next.next;
                       temp1=temp1.next.next;
                   }
                   int val=temp.val;
                   temp.val=temp1.val;
                   temp1.val=val;
                   return head;
               }
           }
    }
    
}
