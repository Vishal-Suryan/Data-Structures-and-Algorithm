public class deleteAllxDLL {
    
public class deleteNodexDLL {
    class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head==null){
            return null;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                if(temp==head){
                    head=head.next;
                }else{
                    Node nextNode=temp.next;
                    Node prevNode=temp.prev;
                    if(prevNode!=null){
                        prevNode.next=nextNode;
                    }
                    if(nextNode!=null){
                        nextNode.prev=prevNode;
                    }
                }
                temp=temp.next;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }
}
}

}
