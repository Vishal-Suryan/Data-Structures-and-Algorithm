public class lengthOfLoopLL {
    class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}



//Function should return the length of the loop in LL.

class Solution
{
    static int findLength(Node slow,Node fast){
        fast=fast.next;
        int count=0;
        while(slow!=fast){
            fast=fast.next;
            count++;
        }
        return count+1;
    }
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
       Node fast=head;
       Node slow=head;
       int count=0;
       while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if(slow==fast){
               return findLength(slow,fast);
           }
       }
       return 0;
    }
}
}
