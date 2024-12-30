
public class diameterBT {
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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int[] diameter = new int[]{0};
        dfs(root,diameter);
        return diameter[0];
    }
    private static int dfs(TreeNode node , int[] diameter){
        if(node==null) return 0;
        int leftHeight=dfs(node.left , diameter);
        int rightHeight=dfs(node.right, diameter);
        diameter[0]=Math.max(diameter[0],(leftHeight + rightHeight));
        return Math.max(leftHeight , rightHeight) + 1;
    }
}
}
