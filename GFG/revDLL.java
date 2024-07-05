public class revDLL {
    class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public static Node reverseDLL(Node  head)
{
    //Your code here
    if(head==null || head.next==null){
        return head;
    }
    Node x=null;
    Node temp=head;
    while(temp!=null){
        x=temp.prev;
        temp.prev=temp.next;
        temp.next=x;
        temp=temp.prev;

    }
    return x.prev;
}
}
