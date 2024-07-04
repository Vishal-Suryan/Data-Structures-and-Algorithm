public class deleteDLL {
    class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

class Solution {
    public Node deleteNode(Node head, int x) {
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            if(count==x){
                break;
            }
            temp=temp.next;
        }
        Node prev=temp.prev;
        Node front=temp.next;
        if(front==null && prev==null){
            return null;
        }else if(prev==null){
            head=head.next;
            head.prev=null;
            return head;
        }else if(front==null){
            temp.prev.next=null;
            temp.prev=null;
            return head;
        }else{
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
            temp.next=null;
            temp.prev=null;
        }
        return head;
    }
}
}
