public class lengthLL {
    class Node{
        int data;
        Node next;
        Node(int a){  data = a; next = null; }
    }
    
    class Solution
    {
        //Function to count nodes of a linked list.
        public static int getCount(Node head)
        {   
            //Code here
            Node temp=head;
            int count=0;
            while(temp!= null){
                count++;
                temp=temp.next;
            }
            return count;
        }
    }
        
}
