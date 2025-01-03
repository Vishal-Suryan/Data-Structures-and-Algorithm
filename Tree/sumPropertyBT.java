public class sumPropertyBT {
    class Node{
        int data;
        Node left,right;
        
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    
  
    class Solution
    {
        public static int isSumProperty(Node root) {
            if (root == null) return 1;
            return (dfs(root) != -1 ? 1 : 0); 
        }
        private static int dfs(Node root) {
            if (root == null) return 0; 
            int left = dfs(root.left);
            int right = dfs(root.right);
            if (left == -1 || right == -1 || 
                (root.left != null || root.right != null) 
                && (left + right != root.data)) {
                return -1;
            }
            return root.data;
        }
    }
}
