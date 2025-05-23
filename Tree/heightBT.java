import java.util.LinkedList;
import java.util.Queue;
public class heightBT {
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
        public int maxDepth_recursion(TreeNode root) {
            if(root==null){
                return 0;
            }
            int leftHeight=maxDepth_recursion(root.left);
            int rightHeight=maxDepth_recursion(root.right);
            return Math.max(leftHeight,rightHeight) + 1;
        }
        public int maxDepth(TreeNode root) {
            int count =0;
            if(root==null){
                return count;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int size =q.size();
                for(int i=0;i<size;i++){
                    TreeNode node =q.poll();
                    if(node.left!=null){
                        q.offer(node.left);
                    }
                    if(node.right!=null){
                        q.offer(node.right);
                    }
                }
                count++;
            }
            return count;
        }
    }
}
