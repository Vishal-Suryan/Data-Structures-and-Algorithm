public class mergeNode_2181 {
  public class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp=head.next;
        ListNode nextSum=temp;
        while(nextSum!=null){
            int sum=0;
            while(nextSum.val!=0){
                sum+=nextSum.val;
                nextSum=nextSum.next;
            }
            temp.val=sum;
            nextSum=nextSum.next;
            temp.next=nextSum;
            temp=temp.next;
        }
        return head.next;
    }
}
}
