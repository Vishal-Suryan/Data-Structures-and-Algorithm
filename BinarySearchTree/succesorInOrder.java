import java.util.Stack;

public class succesorInOrder {
    class Node{
        int data;
        Node left,right;
        
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    class Solution {
        // returns the inorder successor of the Node x in BST (rooted at 'root')
        public int inorderSuccessor(Node root, Node x) {
            // add code here.
            Stack<Node> st=new Stack<>();
            Node curr=root;
            boolean flag=false;
            while(true){
                if(curr!=null){
                    st.push(curr);
                    curr=curr.left;
                }else{
                    if(st.isEmpty()) break;
                    if(flag){
                        return st.pop().data;
                    }
                    curr=st.pop();
                    if(curr == x) flag=true;
                    curr=curr.right;
                }
            }
            return -1;
                
        }
    }
}
