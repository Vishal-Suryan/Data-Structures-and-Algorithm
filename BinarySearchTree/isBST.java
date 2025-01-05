//given an array of inOrder traversal 
public class isBST {
    class Solution {
        static boolean isBSTTraversal(int arr[]) {
            // code here
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>=arr[i+1]){
                    return false;
                }
            }
            return true;
        }
    }
    
}
