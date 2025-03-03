
public class symmetricTree {
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        public boolean isSymmetric(TreeNode root) {
            if(root==null) return true;
            return dfs(root.left,root.right);
        }
        public static boolean dfs(TreeNode l,TreeNode r){
            if(l==null && r==null) return true;
            if(l==null || r==null || l.val!=r.val) return false;
            return dfs(l.left,r.right) && dfs(l.right,r.left); 
        }
    }
}
