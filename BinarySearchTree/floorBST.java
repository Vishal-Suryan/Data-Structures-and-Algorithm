
public class floorBST {
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
    class Solution {
        public static int floor(Node root, int x) {
            // Code here
            if(root==null) return -1;
            int floor=-1;
            while(root!=null){
                if(root.data==floor){
                    return root.data;
                }
                if(root.data>x){
                    root=root.left;
                }else{
                    floor=root.data;
                    root=root.right;
                }
            }
            return floor;
        }
    }
}
