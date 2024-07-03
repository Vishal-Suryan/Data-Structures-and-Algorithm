public class searchLL {
    class Node {
     int data;
      Node next;
      Node(int d)  { data = d;  next = null; }
  }
  
  class Solution {
      static boolean searchKey(int n, Node head, int key) {
          // Code here
          Node temp=head;
          while(n>0){
              if(temp.data==key){
                  return true;
              }
              temp=temp.next;
              n--;
          }
          return false;
      }
  }    
  }
  