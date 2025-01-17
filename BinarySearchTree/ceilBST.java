
public class ceilBST {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    class Tree {
        // Function to return the ceil of given number in BST.
        int findCeil(Node root, int key) {
            if (root == null) return -1;
            int ceil=-1;
            while(root!=null){
                if(root.data==key){
                    return root.data;    
                }
                if(root.data>key){
                    ceil=root.data;
                    root=root.left;
                }else{
                    root=root.right;
                }
            }
            return ceil;
            // Code here
        }
    }
    
}
