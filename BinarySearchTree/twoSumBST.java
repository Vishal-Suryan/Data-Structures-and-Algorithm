import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class twoSumBST {
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
        public boolean findTarget(TreeNode root, int k) {
            HashSet<Integer>set=new HashSet<>();
            Queue<TreeNode>q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                TreeNode curr=q.poll();
                if (set.contains(curr.val)) {
                    return true;
                }
                set.add(k - curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            return false;
        }
    }
}
