
public class removeDupNode_82 {
    public class removeDuplicate {
        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
       
      class Solution {
          public ListNode deleteDuplicates(ListNode head) {
              if(head==null || head.next==null) return head;
              ListNode temp=head;
              ListNode temp1=head.next;
              ListNode dummy=new ListNode(-1);
              ListNode res=dummy;
              while(temp1!=null){
                  if(temp.val==temp1.val){
                      while(temp1!=null && temp.val==temp1.val){
                          temp1=temp1.next;
                      }
                      temp=temp1;
                      if(temp1!=null){
                          temp1=temp1.next;
                      }
                  }else{
                      res.next=temp;
                      res=res.next;
                      temp=temp.next;
                      temp1=temp1.next;
                  }
              }
              res.next=temp;
              return dummy.next;
          }
      }
      }
      
}
