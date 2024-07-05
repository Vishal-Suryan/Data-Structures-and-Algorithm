
public class minmaxNode_2058 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result=new int[]{-1,-1};
        int firstIdx=0;
        int prevIdx=0;
        ListNode temp=head.next;
        ListNode prev=head;
        int count=1;
        int min=Integer.MAX_VALUE;
        while(temp.next!=null){
            if((temp.val > prev.val && temp.val > temp.next.val) ||
            (temp.val < prev.val && temp.val < temp.next.val)){
                if(prevIdx==0){
                    firstIdx=count;
                    prevIdx=count;
                }else{
                    min=Math.min(min,count-prevIdx);
                }
                prevIdx=count;
            }
            count++;
            temp=temp.next;
            prev=prev.next;
        }
        if(min!=Integer.MAX_VALUE){
            return new int[] {min,prevIdx-firstIdx};
        }
        return result;
    }
}
}
