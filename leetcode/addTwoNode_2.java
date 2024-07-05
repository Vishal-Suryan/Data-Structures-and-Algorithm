public class addTwoNode_2 {
    
public class addTwo {
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
       
      class Solution {
          public ListNode addTwoNumbers(ListNode temp1, ListNode temp2) {
              ListNode dummy=new ListNode();
              ListNode curr=dummy;
              int carry=0;
              while(temp1!=null || temp2!=null || carry==1){
                  int sum=0;
                  if(temp1 != null){
                      sum+=temp1.val;
                      temp1=temp1.next;
                  }
                  if(temp2 != null){
                      sum+=temp2.val;
                      temp2=temp2.next;
                  }
                  sum+=carry;
                  carry=sum/10;
                  ListNode newNode=new ListNode(sum%10);
                  curr.next=newNode;
                  curr=curr.next;  
              }
              return dummy.next;
          }
      }
}

}
