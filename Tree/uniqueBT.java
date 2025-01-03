public class uniqueBT {
    class Solution{
        // for a unique BT we need inOrder Traversal and one among post or pre order traversal 
        // for this question -
        //     preOrder Traversal is represented by 1
        //     inOrder Traversal is represented by 2
        //     postOrder Traversal is represented by 3
        public static boolean isPossible(int a, int b){
            // Code here
            if((a==2 || b==2) &&a!=b) return true;
            return false;
        }
    }
}