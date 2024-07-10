public class addOneLL {
    static class Node{
        int data;
        Node next;
        
        Node(int x){
            data = x;
            next = null;
        }
    } 
    
    
    class Solution
    {
        public static Node reverse(Node head){
            Node prev=null;
            Node temp=head;
            while(temp!=null){
                Node front=temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
            }
            return prev;
        }
        public static Node addOne(Node head) 
        { 
            //code here.
            if(head==null){
                return null;
            }
            int carry=1;
            Node temp=reverse(head);
            Node dHead=temp;
            while(temp!=null){
                int sum=temp.data + carry;
                temp.data=sum%10;
                carry=sum/10;
                if(carry==0){
                    return reverse(dHead);
                }
                temp=temp.next;
            }
            temp=reverse(dHead);
            if(carry!=0){
                Node nH=new Node(carry);
                nH.next=temp;
                return nH;
            }
            return null;
        }
    }
}
