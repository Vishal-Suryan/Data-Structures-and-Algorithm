public class merge2LL {
     public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
        
       class Solution {
           public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
               if(list1==null) return list2;
               if(list2==null) return list1;
               if(list1==null && list2==null ) return null;
               ListNode temp=list1;
               ListNode temp1=list2;
               ListNode dummy=new ListNode(-1);
               ListNode res=dummy;
               while(temp!=null && temp1!=null){
                   if(temp.val<temp1.val){
                       res.next=temp;
                       res=temp;
                       temp=temp.next;
                   }else{
                       res.next=temp1;
                       res=temp1;
                       temp1=temp1.next;
                   }
               }
               if(temp!=null){
                   while(temp!=null){
                       res.next=temp;
                       res=temp;
                       temp=temp.next;
                   }
               }else{
                   while(temp1!=null){
                       res.next=temp1;
                       res=temp1;
                       temp1=temp1.next;
                   }
               }
               return dummy.next;
           }
       }
}
