public class balancedBT {
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
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }
            int leftHeight=getHeight(root.left);
            int rightHeight=getHeight(root.right);
            if(Math.abs(leftHeight - rightHeight)<=1 && isBalanced(root.left) 
                && isBalanced(root.right)){
                return true;
            }
            return false;
        }
        private static int getHeight(TreeNode node){
            if(node==null){
                return 0;
            }
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
