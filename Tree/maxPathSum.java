
public class maxPathSum {
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
    public int maxPathSum(TreeNode root) {
        int[] sum= new int[1];
        sum[0]=Integer.MIN_VALUE;
        dfs(root,sum);
        return sum[0];
    }
    private static int dfs(TreeNode node,int[] sum){
        if(node == null) return 0;
        int leftsum = Math.max(0,dfs(node.left,sum));
        int rightsum = Math.max(0,dfs(node.right,sum));
        sum[0]=Math.max(sum[0],leftsum+rightsum+node.val);
        return node.val + Math.max(leftsum,rightsum);
    }
}
}
