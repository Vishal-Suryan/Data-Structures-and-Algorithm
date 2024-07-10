import java.util.HashMap;
import java.util.Map;

public class intersectionPointLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
 
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Map<ListNode,Integer>mp=new HashMap<>();
            ListNode temp=headA;
            while(temp!=null){
                mp.put(temp,1);
                temp=temp.next;
            }
            ListNode temp1=headB;
            while(temp1!=null){
                if(mp.containsKey(temp1)){
                    return temp1;
                }
                temp1=temp1.next;
            }
            return null;
        }
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            int len=0;
            int len1=0;
            ListNode temp=headA;
            ListNode temp1=headB;
            while(temp!=null){
                len++;
                temp=temp.next;
            }
            while(temp1!=null){
                len1++;
                temp1=temp1.next;
            }
            temp=headA ;
            temp1=headB;
            if(len==len1){
                while(temp!=null){
                    if(temp==temp1){
                        return temp;
                    }
                    temp=temp.next;
                    temp1=temp1.next;
                }
            }else if(len>len1){
                int d=len-len1;
                while(d!=0){
                    temp=temp.next;
                    d--;
                }
                while(temp!=null){
                    if(temp==temp1){
                        return temp;
                    }
                    temp=temp.next;
                    temp1=temp1.next;
                }
            }else{
                int d=len1-len;
                while(d!=0){
                    temp1=temp1.next;
                    d--;
                }
                while(temp!=null){
                    if(temp==temp1){
                        return temp;
                    }
                    temp=temp.next;
                    temp1=temp1.next;
                }
            }
            return null;
        }
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            ListNode temp=headA;
            ListNode temp1=headB;
            while(temp!=temp1){
                temp=temp.next;
                temp1=temp1.next;
                if(temp==temp1){
                    return temp;
                }
                if(temp==null){
                    temp=headB;
                }
                if(temp1==null){
                    temp1=headA;
                }
            }
            return temp;
        }
    }
}
