
public class flattenLL {
    static class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

class GfG {
    private static Node merge(Node headA,Node headB){
        Node dummyNode =new Node(-1);
        Node res=dummyNode;
        while(headA!=null && headB!=null){
            if(headA.data<headB.data){
                res.bottom=headA;
                res=headA;
                headA=headA.bottom;
            }else{
                res.bottom=headB;
                res=headB;
                headB=headB.bottom;
            }
            res.next=null;
        }
        if(headA!=null){
            res.bottom=headA;
        }else{
            res.bottom=headB;
        }
        return dummyNode.bottom;
    }
    Node flatten(Node head) {
        // Your code here
        if(head==null || head.next==null){
            return head;
        }
        Node mergeH=flatten(head.next);
        return merge(head,mergeH);
    }
}
}
