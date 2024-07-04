public class insertDLL {
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

class GfG
{
    //Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int pos, int data)
	{
		// Your code here
		if(head_ref==null)return;
        
		Node temp=head_ref;
		int count=-1;
		while(temp!=null){
		    count++;
		    if(count==pos){
		        break;
		    }
		    temp=temp.next;
		}
		Node newNode=new Node(data);
		newNode.next=temp.next;
		//temp.next.prev=newNode;
		temp.next=newNode;
		newNode.prev=temp;
	    return ;
	}
}
}
